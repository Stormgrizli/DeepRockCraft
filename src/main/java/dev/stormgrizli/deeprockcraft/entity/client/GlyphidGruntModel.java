package dev.stormgrizli.deeprockcraft.entity.client;// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class GlyphidGruntModel<T extends Entity> extends EntityModel<T> {
	private final ModelPart glyphidgrunt;
	private final ModelPart body;
	private final ModelPart mouthdown;
	private final ModelPart mouthup;
	private final ModelPart BackBody;
	private final ModelPart mainarmr2;
	private final ModelPart mainarm22;
	private final ModelPart mainarm222;
	private final ModelPart mainarmr;
	private final ModelPart mainarm1;
	private final ModelPart mainarm11;

	public GlyphidGruntModel(ModelPart root) {
		this.glyphidgrunt = root;
		this.body = root.getChild("glyphidgrunt");
		this.mouthdown = root.getChild("glyphidgrunt").getChild("body");
		this.mouthup = root.getChild("glyphidgrunt").getChild("body");
		this.BackBody = root.getChild("glyphidgrunt").getChild("body");
		this.mainarmr2 = root.getChild("glyphidgrunt").getChild("body");
		this.mainarm22 = root.getChild("glyphidgrunt").getChild("body");
		this.mainarm222 = root.getChild("glyphidgrunt").getChild("body");
		this.mainarmr = root.getChild("glyphidgrunt").getChild("body");
		this.mainarm1 = root.getChild("glyphidgrunt").getChild("body");
		this.mainarm11 = root.getChild("glyphidgrunt").getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition glyphidgrunt = partdefinition.addOrReplaceChild("glyphidgrunt", CubeListBuilder.create(), PartPose.offset(8.472F, 23.5832F, 2.552F));

		PartDefinition body = glyphidgrunt.addOrReplaceChild("body", CubeListBuilder.create().texOffs(53, 45).addBox(-9.1F, -4.0F, -2.5F, 7.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(47, 59).addBox(-9.3F, -5.0F, -1.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.172F, -8.5832F, -6.052F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(49, 54).addBox(-4.0F, 3.85F, 0.7936F, 8.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3F, -7.2316F, 13.5365F, 0.4014F, 0.0F, 0.0F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(33, 3).addBox(-4.0F, -0.75F, -3.2064F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(29, 0).addBox(-4.0F, 0.25F, -3.2064F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3F, -7.4316F, 13.8365F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(33, 31).addBox(-3.0F, -2.75F, -15.2064F, 6.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(0, 21).addBox(-5.0F, -1.75F, -15.2064F, 10.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3F, -7.2316F, 13.5365F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -6.5F, 8.0F, 8.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3F, -2.546F, 5.1432F, 0.2618F, 0.0F, 0.0F));

		PartDefinition mouthdown = body.addOrReplaceChild("mouthdown", CubeListBuilder.create(), PartPose.offset(-5.3F, 4.0062F, -1.7415F));

		PartDefinition cube_r5 = mouthdown.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(59, 61).addBox(2.8F, -0.1646F, -0.9229F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(51, 61).addBox(-3.9F, -0.1646F, -0.9229F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(49, 45).addBox(1.2F, 0.0354F, -0.9229F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 32).addBox(-3.0F, -0.5646F, -1.7229F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 32).addBox(2.0F, -0.5646F, -1.7229F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(29, 11).addBox(-2.0F, -0.8646F, -2.7229F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -4.0F, 0.6283F, 0.0F, 0.0F));

		PartDefinition cube_r6 = mouthdown.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(20, 52).addBox(2.3376F, -1.6893F, 1.4416F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -4.0F, 0.3621F, 0.3941F, 0.253F));

		PartDefinition cube_r7 = mouthdown.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(69, 63).addBox(-3.7564F, -1.9457F, 0.394F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -4.0F, 0.3651F, -0.0868F, -0.1639F));

		PartDefinition cube_r8 = mouthdown.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(68, 54).addBox(1.6355F, -2.4251F, -2.0889F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -4.0F, 0.3022F, -0.2338F, 0.1267F));

		PartDefinition cube_r9 = mouthdown.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(50, 0).addBox(-2.1044F, -1.8787F, -2.7667F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -4.0F, 0.0823F, 0.5659F, -0.1385F));

		PartDefinition cube_r10 = mouthdown.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 49).addBox(0.5808F, -1.8325F, -2.8889F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -4.0F, 0.353F, -0.1434F, -0.1424F));

		PartDefinition cube_r11 = mouthdown.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(39, 63).addBox(0.4971F, -1.9325F, -2.4091F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -4.0F, 0.3773F, 0.38F, 0.0562F));

		PartDefinition cube_r12 = mouthdown.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(63, 18).addBox(-2.0F, -1.6545F, -2.5271F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -4.0F, 0.1396F, 0.0F, 0.0F));

		PartDefinition cube_r13 = mouthdown.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(42, 41).addBox(2.0F, 0.5938F, -1.3585F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(45, 45).addBox(3.0F, -1.4062F, 1.2415F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 45).addBox(-4.0F, -1.4062F, 1.2415F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(39, 11).addBox(-3.0F, 0.5938F, -1.3585F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(21, 36).addBox(-4.0F, 0.5938F, -0.3585F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(33, 31).addBox(-2.0F, 0.5938F, -2.2585F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -4.0F, 0.3665F, 0.0F, 0.0F));

		PartDefinition mouthup = body.addOrReplaceChild("mouthup", CubeListBuilder.create().texOffs(32, 69).addBox(2.9141F, -0.586F, -2.255F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 41).addBox(-2.0859F, -1.586F, -5.755F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(21, 60).addBox(-3.0859F, -1.586F, -4.855F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(58, 40).addBox(1.9141F, -1.586F, -4.855F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 0).addBox(-4.0859F, -1.586F, -3.855F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(70, 0).addBox(-4.0859F, -0.586F, -2.255F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.2141F, -1.414F, -2.245F));

		PartDefinition cube_r14 = mouthup.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(16, 51).addBox(1.2F, -1.4F, 0.8F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 62).addBox(2.8F, -1.2F, 0.8F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 64).addBox(-3.9F, -1.2F, 0.8F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(31, 55).addBox(2.0F, -0.8F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 55).addBox(-3.0F, -0.8F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(42, 55).addBox(-2.0F, -0.5F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0859F, -0.086F, -5.255F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r15 = mouthup.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(12, 70).addBox(-0.3F, -1.1F, -0.1F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4317F, 1.181F, -5.0172F, 0.067F, -0.1731F, -0.2022F));

		PartDefinition cube_r16 = mouthup.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 72).addBox(-0.7F, -1.1F, -0.6F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.6012F, 0.4058F, -2.9814F, 0.0349F, 0.4571F, -0.0872F));

		PartDefinition cube_r17 = mouthup.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(70, 44).addBox(-0.5F, -1.0F, -0.3F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4976F, 0.5417F, -3.2625F, 0.0F, -0.1396F, 0.1222F));

		PartDefinition cube_r18 = mouthup.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(4, 72).addBox(-1.1F, -1.5F, -0.6F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2976F, 1.3417F, -4.4625F, 0.3286F, 0.4767F, 0.3455F));

		PartDefinition cube_r19 = mouthup.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(16, 70).addBox(-1.7F, -1.1F, -0.9F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4317F, 1.181F, -5.0172F, 0.0162F, -0.1848F, 0.0814F));

		PartDefinition cube_r20 = mouthup.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(71, 11).addBox(0.0F, -0.3F, -1.2F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0859F, 0.262F, -4.7998F, 0.0171F, 0.3736F, 0.0906F));

		PartDefinition cube_r21 = mouthup.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(71, 56).addBox(-2.0F, -0.3F, -1.2F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0859F, 0.262F, -4.7998F, 0.2269F, 0.0F, 0.0F));

		PartDefinition BackBody = body.addOrReplaceChild("BackBody", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.3F, -5.2316F, 11.5365F, -0.1571F, 0.0F, 0.0F));

		PartDefinition cube_r22 = BackBody.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 49).addBox(-3.0F, -2.6113F, 8.9026F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 36).addBox(-4.0F, -3.6113F, 5.9026F, 8.0F, 8.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(33, 11).addBox(-5.0F, -4.6113F, -2.0974F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 2.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition mainarmr2 = body.addOrReplaceChild("mainarmr2", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.6F, -3.9F, 1.2F, 0.0F, 0.1745F, 0.0F));

		PartDefinition cube_r23 = mainarmr2.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(8, 66).addBox(-0.9F, -5.5F, -2.4F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5565F, 1.037F, -4.3215F, 1.1781F, 0.0F, 0.192F));

		PartDefinition cube_r24 = mainarmr2.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(55, 68).addBox(-1.0F, -1.7F, -2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4478F, 4.6316F, -2.823F, -1.789F, 0.0F, 0.192F));

		PartDefinition mainarm22 = mainarmr2.addOrReplaceChild("mainarm22", CubeListBuilder.create(), PartPose.offset(-0.2244F, 0.5146F, -9.0898F));

		PartDefinition cube_r25 = mainarm22.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(32, 45).addBox(-1.5F, -1.5F, -6.0F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(69, 16).addBox(-1.0F, -0.5F, 1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.9F, -3.0F, 0.4363F, 0.0F, 0.192F));

		PartDefinition cube_r26 = mainarm22.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(45, 49).addBox(-0.4F, -1.5F, -5.9F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.137F, 6.6495F, -11.6283F, 1.4573F, 0.0F, 0.192F));

		PartDefinition cube_r27 = mainarm22.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(0, 59).addBox(-0.9F, -1.1F, -4.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.137F, 6.7495F, -11.6283F, 1.2654F, 0.0F, 0.192F));

		PartDefinition cube_r28 = mainarm22.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(31, 55).addBox(-1.5F, -1.5F, -4.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5644F, 3.8034F, -8.7957F, 0.7418F, 0.0F, 0.192F));

		PartDefinition mainarm222 = mainarmr2.addOrReplaceChild("mainarm222", CubeListBuilder.create(), PartPose.offset(-0.2F, 3.9F, -1.2F));

		PartDefinition cube_r29 = mainarm222.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(63, 68).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3918F, 0.0267F, 0.2565F));

		PartDefinition mainarmr = body.addOrReplaceChild("mainarmr", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -3.5F, 1.2F, 0.0F, -0.1745F, 0.0F));

		PartDefinition cube_r30 = mainarmr.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(47, 68).addBox(-1.0F, -1.7F, -2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4478F, 4.2316F, -2.823F, -1.789F, 0.0F, -0.192F));

		PartDefinition cube_r31 = mainarmr.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(8, 25).addBox(-0.1F, -5.5F, -2.4F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5565F, 0.637F, -4.3215F, 1.1781F, 0.0F, -0.192F));

		PartDefinition mainarm1 = mainarmr.addOrReplaceChild("mainarm1", CubeListBuilder.create(), PartPose.offset(1.1614F, 0.8641F, -9.7181F));

		PartDefinition cube_r32 = mainarm1.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(42, 57).addBox(-0.6F, -1.5F, -5.9F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.8F, -11.0F, 1.4573F, 0.0F, -0.192F));

		PartDefinition cube_r33 = mainarm1.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(58, 37).addBox(-1.1F, -1.1F, -4.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, -11.0F, 1.2654F, 0.0F, -0.192F));

		PartDefinition cube_r34 = mainarm1.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(20, 52).addBox(-1.5F, -1.5F, -4.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5727F, 3.0539F, -8.1674F, 0.7418F, 0.0F, -0.192F));

		PartDefinition cube_r35 = mainarm1.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(19, 42).addBox(-1.5F, -1.5F, -6.0F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(67, 59).addBox(-1.0F, -0.5F, 1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.137F, 0.1505F, -2.3717F, 0.4363F, 0.0F, -0.192F));

		PartDefinition mainarm11 = mainarmr.addOrReplaceChild("mainarm11", CubeListBuilder.create(), PartPose.offset(0.2F, 3.5F, -1.2F));

		PartDefinition cube_r36 = mainarm11.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(28, 68).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3918F, -0.0267F, -0.2565F));

		PartDefinition arm1 = body.addOrReplaceChild("1arm", CubeListBuilder.create(), PartPose.offset(3.172F, 8.5832F, 6.052F));

		PartDefinition cube_r37 = arm1.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(58, 37).addBox(-1.7F, -1.3F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2F, 0.1F, -2.9F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r38 = arm1.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 66).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2985F, -4.1007F, -3.6406F, 0.1586F, 0.7677F, 0.184F));

		PartDefinition cube_r39 = arm1.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(0, 25).addBox(2.9F, 0.2F, -2.3F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6089F, -8.2155F, 0.8937F, -0.3001F, 0.7322F, -0.4759F));

		PartDefinition cube_r40 = arm1.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(9, 60).addBox(-0.5F, -1.0F, -2.2F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(55, 5).addBox(-0.5F, -0.5F, -1.7F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8089F, -8.7155F, 3.7937F, -0.0381F, 0.7799F, -0.0965F));

		PartDefinition arm2 = body.addOrReplaceChild("2arm", CubeListBuilder.create(), PartPose.offset(-9.772F, -0.4168F, 9.052F));

		PartDefinition cube_r41 = arm2.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(0, 59).addBox(-0.5058F, 2.3842F, -0.5212F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8942F, 5.4158F, -6.5788F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r42 = arm2.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(67, 66).addBox(-1.3291F, -1.5637F, -0.9566F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8942F, 5.6158F, -6.5788F, 0.1586F, -0.7677F, -0.184F));

		PartDefinition cube_r43 = arm2.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(23, 60).addBox(-1.901F, -5.7733F, -0.9566F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8942F, 5.7158F, -6.5788F, -0.3001F, -0.7322F, 0.4759F));

		PartDefinition cube_r44 = arm2.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(67, 37).addBox(-2.5F, -1.0F, -2.2F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(55, 7).addBox(-8.5F, -0.5F, -1.7F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1911F, 0.2845F, 0.7937F, -0.0381F, -0.7799F, 0.0965F));

		PartDefinition arm3 = body.addOrReplaceChild("3arm", CubeListBuilder.create(), PartPose.offset(-1.9449F, -1.079F, 10.1125F));

		PartDefinition cube_r45 = arm3.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(21, 36).addBox(0.4169F, 3.3622F, -1.4606F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.1F, 5.4F, -0.3F, 0.0296F, -0.6652F, 0.1723F));
		PartDefinition cube_r46 = arm3.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(31, 63).addBox(0.7548F, -0.7678F, -1.0126F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.1F, 5.4F, -0.3F, 0.0679F, 0.1067F, 0.326F));
		PartDefinition cube_r47 = arm3.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(45, 61).addBox(0.798F, -4.409F, -1.0126F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.1F, 5.4F, -0.3F, 0.0108F, 0.1259F, -0.157F));
		PartDefinition cube_r48 = arm3.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(0, 4).addBox(-3.3014F, -5.4678F, -0.9007F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(55, 9).addBox(-3.3014F, -5.0678F, -0.4007F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 5.0F, 0.0F, 0.0326F, 0.1221F, 0.0189F));

		PartDefinition arm4 = body.addOrReplaceChild("4arm", CubeListBuilder.create(), PartPose.offset(-8.9938F, -1.0838F, 9.7604F));

		PartDefinition cube_r49 = arm4.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(41, 36).addBox(-1.4169F, 3.3622F, -1.4606F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.1612F, 5.0048F, -0.0478F, 0.0296F, 0.6652F, -0.1723F));
		PartDefinition cube_r50 = arm4.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(12, 64).addBox(-2.7548F, -0.7678F, -1.0126F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.1612F, 5.0048F, -0.0478F, 0.0679F, -0.1067F, -0.326F));
		PartDefinition cube_r51 = arm4.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(63, 11).addBox(-2.798F, -4.409F, -1.0126F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.1612F, 5.0048F, -0.0478F, 0.0108F, -0.1259F, 0.157F));
		PartDefinition cube_r52 = arm4.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(0, 21).addBox(-0.6986F, -6.0678F, -1.4007F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6612F, 5.5048F, 0.8522F, 0.0326F, -0.1221F, -0.0189F));
		PartDefinition cube_r53 = arm4.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(58, 35).addBox(-5.6986F, -5.0678F, -0.4007F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6612F, 5.0048F, 0.3522F, 0.0326F, -0.1221F, -0.0189F));

		PartDefinition arm5 = body.addOrReplaceChild("5arm", CubeListBuilder.create(), PartPose.offset(1.0551F, 3.321F, 13.1125F));

		PartDefinition cube_r54 = arm5.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(29, 0).addBox(0.4169F, 3.3622F, -1.4606F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 0.0F, 2.3F, -0.3604F, -1.2926F, 0.3827F));

		PartDefinition cube_r55 = arm5.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(39, 66).addBox(0.7548F, -0.7678F, -1.0126F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 0.0F, 2.3F, -0.1575F, -0.5109F, 0.2427F));

		PartDefinition cube_r56 = arm5.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(53, 61).addBox(0.798F, -4.409F, -1.0126F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 0.0F, 2.3F, 0.1206F, -0.52F, -0.3106F));

		PartDefinition cube_r57 = arm5.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(0, 0).addBox(-3.3014F, -5.5678F, -0.9007F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(58, 31).addBox(-3.3014F, -5.0678F, -0.4007F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0192F, -0.5322F, -0.1091F));

		PartDefinition arm6 = body.addOrReplaceChild("6arm", CubeListBuilder.create(), PartPose.offset(-11.6551F, 3.321F, 13.1125F));

		PartDefinition cube_r58 = arm6.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(0, 36).addBox(-1.4169F, 3.3622F, -1.4606F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6F, 0.0F, 2.2F, -0.3604F, 1.2926F, -0.3827F));

		PartDefinition cube_r59 = arm6.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(20, 67).addBox(-2.7548F, -0.7678F, -1.0126F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6F, 0.0F, 2.2F, -0.1575F, 0.5109F, -0.2427F));

		PartDefinition cube_r60 = arm6.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(61, 61).addBox(-2.798F, -4.409F, -1.0126F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6F, 0.0F, 2.2F, 0.1206F, 0.52F, 0.3106F));
		PartDefinition cube_r61 = arm6.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(0, 8).addBox(-0.6986F, -5.5678F, -0.9007F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(58, 33).addBox(-5.6986F, -5.0678F, -0.4007F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0192F, 0.5322F, 0.1091F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		glyphidgrunt.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}