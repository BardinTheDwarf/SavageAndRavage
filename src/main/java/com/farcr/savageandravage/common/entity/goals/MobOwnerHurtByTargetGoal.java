package com.farcr.savageandravage.common.entity.goals;

import com.farcr.savageandravage.common.entity.IOwnableMob;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.TargetGoal;

import java.util.EnumSet;

public class MobOwnerHurtByTargetGoal extends TargetGoal {
    private final IOwnableMob defendingEntity;
    private LivingEntity attacker;
    private int timestamp;

    public MobOwnerHurtByTargetGoal(MobEntity theDefendingdefendingEntityIn) {
        super(theDefendingdefendingEntityIn, false);
        this.defendingEntity = (IOwnableMob)theDefendingdefendingEntityIn;
        this.setMutexFlags(EnumSet.of(Goal.Flag.TARGET));
    }

    /**
     * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
     * method as well.
     */
    public boolean shouldExecute() {
        if (this.defendingEntity.getOwnerId()!=null) {
            LivingEntity livingentity = this.defendingEntity.getOwner();
            if (livingentity == null) {
                return false;
            } else {
                this.attacker = livingentity.getRevengeTarget();
                int i = livingentity.getRevengeTimer();
                return i != this.timestamp && this.isSuitableTarget(this.attacker, EntityPredicate.DEFAULT) && this.defendingEntity.shouldAttackEntity(this.attacker, livingentity);
            }
        } else {
            return false;
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting() {
        this.goalOwner.setAttackTarget(this.attacker);
        LivingEntity livingentity = this.defendingEntity.getOwner();
        if (livingentity != null) {
            this.timestamp = livingentity.getRevengeTimer();
        }

        super.startExecuting();
    }
}