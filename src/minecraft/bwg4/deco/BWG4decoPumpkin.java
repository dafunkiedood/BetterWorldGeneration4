package bwg4.deco;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BWG4decoPumpkin extends WorldGenerator
{
	private int whatblock;

    public BWG4decoPumpkin(int thisblock)
    {
		whatblock = thisblock;
    }

    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        for (int var6 = 0; var6 < 64; ++var6)
        {
            int var7 = par3 + par2Random.nextInt(8) - par2Random.nextInt(8);
            int var8 = par4 + par2Random.nextInt(4) - par2Random.nextInt(4);
            int var9 = par5 + par2Random.nextInt(8) - par2Random.nextInt(8);

            if (par1World.isAirBlock(var7, var8, var9) && par1World.getBlockId(var7, var8 - 1, var9) == Block.grass.blockID && Block.pumpkin.canPlaceBlockAt(par1World, var7, var8, var9))
            {
				if(whatblock == 0)
				{
					par1World.setBlock(var7, var8, var9, Block.pumpkin.blockID, par2Random.nextInt(4), 0);
				}
				else
				{
					par1World.setBlock(var7, var8, var9, Block.melon.blockID, 0, 0);
				}
            }
        }

        return true;
    }
}
