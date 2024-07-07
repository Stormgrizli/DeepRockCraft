package dev.stormgrizli.deeprockcraft.entity.base;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;

import java.util.Objects;

public class GlyphidPart extends PartEntity<GlyphidBaseEntity> {
    private GlyphidBaseEntity parent;
    protected EntityDimensions realSize = EntityDimensions.fixed(0.5F, 0.5F);

    public GlyphidPart(GlyphidBaseEntity parent, Vec3 offset) {
        super(parent);
        this.setPos(offset);
        this.refreshDimensions();
        this.parent = parent;
    }

    public ItemStack getPickResult() {
        return this.parent.getPickResult();
    }

    @Override
    public boolean isPickable() {
        return true;
    }

    @Override
    public void tick() {
        updateLastPos();
        super.tick();
    }

    public final void updateLastPos() {
        this.moveTo(this.getX(), this.getY(), this.getZ());
        this.yRotO = this.getYRot();
        this.xRotO = this.getXRot();
        this.tickCount++;
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {

    }
    public static void assignPartIDs(Entity parent) {
        PartEntity<?>[] parts = parent.getParts();
        for (int i = 0, partsLength = Objects.requireNonNull(parts).length; i < partsLength; i++) {
            PartEntity<?> part = parts[i];
            part.setId(parent.getId() + i);
        }
    }
    @Override
    public EntityDimensions getDimensions(Pose pose) {
        return this.realSize;
    }
    @Override
    public boolean hurt(DamageSource src, float damage) {
        return !this.isInvisible() && this.getParent().hurt(src, damage * 10.0F);
    }
    protected void setSize(EntityDimensions size) {
        this.realSize = size;
        this.refreshDimensions();
    }
    @Override
    public boolean is(Entity entity) {
        return entity == this || entity == this.getParent();
    }
}
