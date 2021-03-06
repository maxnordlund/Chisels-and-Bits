package mod.chiselsandbits.helpers;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.IFluidContainerItem;

@SuppressWarnings( "deprecation" )
public class DeprecationHelper
{

	public static int getLightValue(
			final IBlockState state )
	{
		return state.getBlock().getLightValue( state );
	}

	public static IBlockState getStateFromItem(
			final ItemStack bitItemStack )
	{
		if ( bitItemStack != null && bitItemStack.getItem() instanceof ItemBlock )
		{
			final ItemBlock blkItem = (ItemBlock) bitItemStack.getItem();
			return blkItem.getBlock().getStateFromMeta( blkItem.getMetadata( bitItemStack ) );
		}

		return null;
	}

	public static IBlockState getStateFromMeta(
			final Block blk,
			final int meta )
	{
		return blk.getStateFromMeta( meta );
	}

	public static String translateToLocal(
			final String string )
	{
		return I18n.translateToLocal( string );
	}

	public static boolean isBucketRegisteryTest(
			final ItemStack current )
	{
		return FluidContainerRegistry.isBucket( current ) || FluidContainerRegistry.isFilledContainer( current ) || current.getItem() instanceof IFluidContainerItem;
	}

	public static String translateToLocal(
			final String string,
			final Object... args )
	{
		return I18n.translateToLocalFormatted( string, args );

	}
}
