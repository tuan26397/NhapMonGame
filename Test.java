package Test;

import static org.junit.jupiter.api.Assertions.*;

import Movement.KinematicFlee;
import Movement.Character;
import Movement.Vector2D;
import Movement.Wandering;

class Test {

	@org.junit.jupiter.api.Test
	void testKinematicFlee() {
		Character character =new Character(new Vector2D(0,0),new Vector2D(1,1),0,0);
		Character target =new Character(new Vector2D(0,0),new Vector2D(0,0),0,0);
		KinematicFlee kinematicFlee=new KinematicFlee(character,target,1);
		character.update(kinematicFlee.generateKinematicOutput(), 1);
		character.applyNewOrientation();
		//velocity=vector2D(1/sqrt(2),1/sqrt(2))
		//position+=velocity*1
		Character expected=new Character(new Vector2D(1.0f/(float)Math.sqrt(2),1.0f/(float)Math.sqrt(2)),new Vector2D(1.0f/(float)Math.sqrt(2)+1,1.0f/(float)Math.sqrt(2)+1),0,-(float)Math.PI/4);
		assertEquals(expected,character);
	}
	
	@org.junit.jupiter.api.Test
	void testWandering() {
		Character character =new Character(new Vector2D(0,0),new Vector2D(0,0),0,0);
		Wandering wandering=new Wandering(character,(float)Math.PI/4,1);
		character.update(wandering.generateKinematicSteeringOutput(), 2);
		float orientation=character.getOrientation();
		float rotation=character.getRotation();
		//maxSpeed=1 =>velocity=1
		//-pi/4<=rotation<=pi/4
		//orientation=time*rotation=2*rotation
		assertEquals(true,character.getVelocity().length()==1 && rotation<=(float)Math.PI/4 && rotation>=-(float)Math.PI/4&&orientation==rotation*2);
		
	}

}
