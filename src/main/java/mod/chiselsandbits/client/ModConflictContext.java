package mod.chiselsandbits.client;

import mod.chiselsandbits.core.ClientSide;
import mod.chiselsandbits.helpers.ChiselToolType;
import mod.chiselsandbits.interfaces.IVoxelBlobItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.client.settings.IKeyConflictContext;
import net.minecraftforge.client.settings.KeyConflictContext;

public enum ModConflictContext implements IKeyConflictContext
{

	HOLDING_ROTATEABLE
	{
		@Override
		public boolean isActive()
		{
			final ItemStack held = ClientSide.instance.getPlayer().getHeldItemMainhand();
			return held != null && held.getItem() instanceof IVoxelBlobItem;
		}

		@Override
		public boolean conflicts(
				final IKeyConflictContext other )
		{
			return this == other || other == KeyConflictContext.IN_GAME || other == HOLDING_MENUITEM;
		}
	},

	HOLDING_MENUITEM
	{
		@Override
		public boolean isActive()
		{
			final ChiselToolType tool = ClientSide.instance.getHeldToolType( EnumHand.MAIN_HAND );
			return tool != null && tool.hasMenu();
		}

		@Override
		public boolean conflicts(
				final IKeyConflictContext other )
		{
			return this == other || other == KeyConflictContext.IN_GAME || other == HOLDING_POSTIVEPATTERN || other == HOLDING_CHISEL || other == HOLDING_TAPEMEASURE;
		}
	},
	HOLDING_TAPEMEASURE
	{
		@Override
		public boolean isActive()
		{
			return ClientSide.instance.getHeldToolType( EnumHand.MAIN_HAND ) == ChiselToolType.TAPEMEASURE;
		}

		@Override
		public boolean conflicts(
				final IKeyConflictContext other )
		{
			return this == other || other == KeyConflictContext.IN_GAME;
		}
	},

	HOLDING_POSTIVEPATTERN
	{
		@Override
		public boolean isActive()
		{
			return ClientSide.instance.getHeldToolType( EnumHand.MAIN_HAND ) == ChiselToolType.POSITIVEPATTERN;
		}

		@Override
		public boolean conflicts(
				final IKeyConflictContext other )
		{
			return this == other || other == KeyConflictContext.IN_GAME;
		}
	},

	HOLDING_CHISEL
	{
		@Override
		public boolean isActive()
		{
			final ChiselToolType tool = ClientSide.instance.getHeldToolType( EnumHand.MAIN_HAND );
			return tool != null && tool.isBitOrChisel();
		}

		@Override
		public boolean conflicts(
				final IKeyConflictContext other )
		{
			return this == other || other == KeyConflictContext.IN_GAME;
		}
	};

}
