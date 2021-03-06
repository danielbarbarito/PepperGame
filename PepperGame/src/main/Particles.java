package main;
import org.newdawn.slick.*;
import java.io.File;
import java.io.IOException;

import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ConfigurableEmitter.Range;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.particles.effects.FireEmitter;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Particles {
	public ParticleSystem ps;
	public ParticleSystem ps2;
	public ParticleSystem ps3;
	public ParticleSystem ps4;
	public ConfigurableEmitter em;
	public ConfigurableEmitter em2; 	
	public ConfigurableEmitter em3; 	
	public File xmlFile;
	public File xmlFile2;
	public File xmlFile3;
	public Particles()
	{
		xmlFile = new File("data/emitter.xml");
		xmlFile2 = new File("data/emitter2.xml");
		xmlFile3 = new File("data/emitter3.xml");
		ps = new ParticleSystem("data/particle.png");
		ps2 = new ParticleSystem("data/particle.png", 1000);
		ps3 = new ParticleSystem("data/particle.png", 1000);
		ps4 = new ParticleSystem("data/particle.png", 1000);
		em = new ConfigurableEmitter("Basic");
		em2 = new ConfigurableEmitter("Background");
		em3 = new ConfigurableEmitter("Tutor Zone");
		try {
			//Default Particle file
			//ParticleIO.saveEmitter(xmlFile, em);
			em = ParticleIO.loadEmitter(xmlFile);
			em2 = ParticleIO.loadEmitter(xmlFile2);
			em3 = ParticleIO.loadEmitter(xmlFile3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ps.addEmitter(em);
		ps2.addEmitter(em);
		ps3.addEmitter(em2);
		ps4.addEmitter(em3);
		ps.setBlendingMode(ParticleSystem.BLEND_ADDITIVE);
		ps2.setBlendingMode(ParticleSystem.BLEND_ADDITIVE);
		ps3.setBlendingMode(ParticleSystem.BLEND_ADDITIVE);
		ps4.setBlendingMode(ParticleSystem.BLEND_ADDITIVE);
		
	}

	public void render()
	{
		ps.render();
		ps2.render();
		ps3.render();
		ps4.render();
		
	}
	public void setPositionPlayer(float x, float y)
	{
		ps.setPosition(x, y);
	}
	public void setPositionABuff(float x, float y)
	{
		ps2.setPosition(x,y);
		
	}
	public void setPositionTutorZone(float x, float y)
	{
		ps4.setPosition(x,y);
		
	}
	public void setPositionBackground(float x, float y)
	{
		ps3.setPosition(x, y);
		
	}
	public void update(int delta)
	{
		ps.update(delta);
		ps2.update(delta);
		ps3.update(delta);
		ps4.update(delta);
	}
}
