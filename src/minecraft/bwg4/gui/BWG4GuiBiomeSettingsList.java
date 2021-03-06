package bwg4.gui;

import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.Tessellator;

class BWG4GuiBiomeSettingsList extends GuiSlot
{
    final BWG4GuiBiomeSettings bwg4guidefault;
	public int selected; 

    public BWG4GuiBiomeSettingsList(BWG4GuiBiomeSettings par1)
    {
        super(par1.minecraft, par1.width, par1.height, 43, par1.height - 60, 24);
        this.bwg4guidefault = par1;
		selected = -1;
    }

    protected int getSize()
    {
		return BWG4GuiBiomeSettings.getBiomeArray(bwg4guidefault).theBiomesList().size();
    }

    protected void elementClicked(int par1, boolean par2)
    {
        this.selected = par1;
        this.bwg4guidefault.setButtons();
    }
	
    protected boolean isSelected(int par1)
    {
		return par1 == selected;
    }	
	
    protected void drawBackground() 
	{
	}
	
    protected void drawSlot(int par1, int par2, int par3, int par4, Tessellator par5Tessellator)
    {
		//GET ARRAY LIST
		BWG4BiomeInfo var6 = (BWG4BiomeInfo)BWG4GuiBiomeSettings.getBiomeArray(this.bwg4guidefault).theBiomesList().get(BWG4GuiBiomeSettings.getBiomeArray(this.bwg4guidefault).theBiomesList().size() - par1 - 1);
		
		//GET DATA
		String name = var6.getNAME();
		boolean enable = var6.getEnabled();
		
		//DISPLAY TEXT
		if(enable == true)
		{	
			bwg4guidefault.fr.drawString(name, par2 + 1, par3 + 7, 16777215);
			bwg4guidefault.fr.drawString("YES", par2 + 179, par3 + 7, 16777215);
		}
		else
		{
			bwg4guidefault.fr.drawString(name, par2 + 1, par3 + 7, 10526880);
			bwg4guidefault.fr.drawString("NO", par2 + 182, par3 + 7, 10526880);
		}
	}

    protected int getScrollBarX()
    {
        return this.bwg4guidefault.width - 70;
    }

	protected void func_130003_c() 
	{
	}
}
