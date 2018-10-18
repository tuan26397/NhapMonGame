/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Movement;

import java.util.Objects;

/**
 *
 * @author Tuan
 */
public class Character {
    private Vector2D velocity;
    private Vector2D position;
    private float rotation;
    private float orientation;

    public Vector2D getVelocity() {
        return velocity;
    }

    public Vector2D getPosition() {
        return position;
    }

    public float getRotation() {
        return rotation;
    }

    public float getOrientation() {
        return orientation;
    }

    public void setVelocity(Vector2D velocity) {
        this.velocity = velocity;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public void setOrientation(float orientation) {
        this.orientation = orientation;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Character other = (Character) obj;
        if (Float.floatToIntBits(this.rotation) != Float.floatToIntBits(other.rotation)) {
            return false;
        }
        if (Float.floatToIntBits(this.orientation) != Float.floatToIntBits(other.orientation)) {
            return false;
        }
        if (!Objects.equals(this.velocity, other.velocity)) {
            return false;
        }
        if (!Objects.equals(this.position, other.position)) {
            return false;
        }
        return true;
    }
    

    public Character(Vector2D velocity, Vector2D position, float rotation, float orientation) {
        this.velocity = velocity;
        this.position = position;
        this.rotation = rotation;
        this.orientation = orientation;
    }

    public Character() {
    }
    
    public void update(KinematicOutput kinematicOutput,float time){
        this.velocity=kinematicOutput.getVelocity();
        this.rotation=kinematicOutput.getRotation();
        this.orientation+=this.rotation*time;
        this.position.addVector2D(Vector2D.mulConstant(velocity,time));
    }
    
    public void applyNewOrientation(){
        if(this.velocity.length()>0)
            this.orientation=(float) Math.atan2(-this.velocity.getX(), this.velocity.getZ());
    }

    @Override
    public String toString() {
        return "Character{" + "velocity=" + velocity + ", position=" + position + ", rotation=" + rotation + ", orientation=" + orientation + '}';
    }
}
