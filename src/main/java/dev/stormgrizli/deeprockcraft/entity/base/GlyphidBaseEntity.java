package dev.stormgrizli.deeprockcraft.entity.base;

import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class GlyphidBaseEntity extends PathfinderMob {
    private final GlyphidPart FrontPart;
    private final GlyphidPart BackPart;
    private final GlyphidPart BackPart2;

    private final GlyphidBaseEntity GlyphidBase = this;

    protected GlyphidBaseEntity(EntityType<? extends PathfinderMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);

        FrontPart  = new GlyphidPart(GlyphidBase,new Vec3(GlyphidBase.getX()+1, GlyphidBase.getY(), GlyphidBase.getZ()));
        BackPart   = new GlyphidPart(GlyphidBase,new Vec3(GlyphidBase.getX()-1, GlyphidBase.getY(), GlyphidBase.getZ()));
        BackPart2   = new GlyphidPart(GlyphidBase,new Vec3(GlyphidBase.getX()-1.5, GlyphidBase.getY()+0.5, GlyphidBase.getZ()));
    }
    @Override
    public void tick() {


        this.moveSegments();
        super.tick();
        //yHeadRot= yBodyRot;
    }
    private void moveSegments() {

        this.FrontPart.tick();
        this.BackPart.tick();
        this.BackPart2.tick();


        float angle;
        double dx, dy, dz;

        angle = (((this.yBodyRot + 180.0F) * Mth.PI) / 180.0F);

        dx = this.getX() - Mth.sin(angle) * - 0.5D;
        dy = this.getY()+ 0.4D;
        dz = this.getZ() + Mth.cos(angle) * - 0.5D;
        this.FrontPart.setPos(dx, dy, dz);

        dx = this.getX() - Mth.sin(angle) * 0.5D;
        dy = this.getY()+ 0.5D;
        dz = this.getZ() + Mth.cos(angle) * 0.5D;
        this.BackPart.setPos(dx, dy, dz);

        dx = this.getX() - Mth.sin(angle) * 1.0D;
        dy = this.getY()+ 1D;
        dz = this.getZ() + Mth.cos(angle) * 1.0D;
        this.BackPart2.setPos(dx, dy, dz);


    }
    @Override
    public void recreateFromPacket(ClientboundAddEntityPacket packet) {
        super.recreateFromPacket(packet);
        GlyphidPart.assignPartIDs(this);
    }

    @Nullable
    @Override
    public PartEntity<?>[] getParts() {
        return new GlyphidPart[]{FrontPart,BackPart,BackPart2};
    }

    @Override
    public void remove(@NotNull RemovalReason reason) {
        super.remove(reason);
        if (this.level() instanceof ServerLevel) {
            FrontPart.kill();
            BackPart.kill();
            BackPart2.kill();

        }
    }
    @Override
    public boolean isMultipartEntity() {
        return true;
    }
}
