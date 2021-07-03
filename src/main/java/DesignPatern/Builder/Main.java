package DesignPatern.Builder;

/**
 *
 *
 * 构建模式
 *
 */
public class Main
{
    public static void main(String[] args)
    {
        TerrainBuilder builder = new ComplexTerrainBuilder();
        Terrain t = builder.buildFort().buildMine().buildWall().build();//链条式的编程，一次完成所有代码的构建
        Person p = new Person.PersonBuilder()
                .basicInfo(1, "zhangsan", 18)
                .score(20)
                .weight(200)
                .loc("bj", "23")
                .build();
        System.out.println(p.age +":"+ p.loc);
    }
}
