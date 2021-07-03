package DesignPatern.Builder;

public interface TerrainBuilder
{
    TerrainBuilder buildWall();
    
    TerrainBuilder buildFort();
    
    TerrainBuilder buildMine();
    
    Terrain build();
}
