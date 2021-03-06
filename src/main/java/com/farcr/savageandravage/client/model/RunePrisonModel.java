package com.farcr.savageandravage.client.model;

import com.farcr.savageandravage.common.entity.RunePrisonEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class RunePrisonModel extends SegmentedModel<RunePrisonEntity> {
    public ModelRenderer plane;

    public RunePrisonModel() {
        this.textureWidth = 42;
        this.textureHeight = 42;
        this.plane = new ModelRenderer(this, 0, 0);
        this.plane.setRotationPoint(-8.0F, 24.0F, -8.0F);
        this.plane.addBox(-5.0F, -5.0F, -5.0F, 21, 0, 21, 0.0F);
    }

    @Override
    public void setRotationAngles(RunePrisonEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(this.plane);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
