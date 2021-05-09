package JavaSE.BLS.Thread.StampedLock;


import java.util.concurrent.locks.StampedLock;

/**
 * java doc 中提供的StampedLock 的示例
 *
 * 首先我们通过tryOptimisticRead()获取一个乐观读锁，并返回版本号。
 * 接着进行读取，读取完成后，我们通过validate()去验证版本号，如果在读取过程中没有写入，版本号不变，验证成功，
 * 我们就可以放心地继续后续操作。如果在读取过程中有写入，版本号会发生变化，验证将失败。
 * 在失败的时候，我们再通过获取悲观读锁再次读取。由于写入的概率不高，程序在绝大部分情况下可以通过乐观读锁获取数据，
 * 极少数情况下使用悲观读锁获取数据。
 */
public class Point
{
    
    private double x, y;
    
    private final StampedLock sl = new StampedLock();
    
    void move(double deltaX, double deltaY)
    {
        long stamp = sl.writeLock();
        try
        {
            x += deltaX;
            y += deltaY;
        } finally
        {
            sl.unlockWrite(stamp);
        }
    }
    
    //乐观锁读锁案例
    double distanceFromOrigin()
    {
        long stamp = sl.tryOptimisticRead();//获取一个乐观锁
        double currentX = x, currentY = y;
        if (!sl.validate(stamp))//检查发生乐观读锁后，是否有其他写锁发生
        {
            stamp = sl.readLock();//如果没有，再获得一个读悲观锁
            try
            {
                currentX = x;
                currentY = y;
            } finally
            {
                sl.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
    
    
    //悲观锁读锁案例
    void moveIfAtOrigin(double newX, double newY)
    {
        long stamp = sl.readLock();//获取读锁
        try
        {
            while (x == 0.0 && y == 0.0)
            {
                long ws = sl.tryConvertToWriteLock(stamp);//尝试将读锁转化为写锁
                
                if (ws != 0L)
                {
                    stamp = ws;//转化为写锁成功，替换stamp
                    x = newX;
                    y = newY;
                    break;
                } else
                {//如果不成功
                    sl.unlockRead(stamp);//显示释放读锁
                    stamp = sl.writeLock();//显示将读锁转化为写锁
                }
            }
        } finally
        {
            sl.unlock(stamp);//释放读锁或写锁
        }
    }
    
}
