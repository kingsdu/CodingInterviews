package JavaSE.BLS.Thread.ForkJoinTask;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class A02_ReadDicFiles extends RecursiveTask<Integer>
{
    private Path dir;
    
    public A02_ReadDicFiles(Path dir)
    {
        this.dir = dir;
    }
    
    @Override
    protected Integer compute()
    {
        int count = 0;
        List<A02_ReadDicFiles> subTasks = new ArrayList<>();
        try
        {
            DirectoryStream<Path> ds = Files.newDirectoryStream(dir);
            for (Path subPath :
                    ds)
            {
                if (Files.isDirectory(subPath, LinkOption.NOFOLLOW_LINKS))
                {
                    subTasks.add(new A02_ReadDicFiles(subPath));
                } else
                {
                    count++;
                }
            }
            
            if (!subTasks.isEmpty())
            {
                for (A02_ReadDicFiles subTask : invokeAll(subTasks))
                {
                    count += subTask.join();
                }
            }
        } catch (IOException e)
        {
            return 0;
        }
        return count;
    }
}
