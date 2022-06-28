package com.mctresdoisdois.acopalipse.view;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;
import com.mctresdoisdois.acopalipse.controller.GameController;

public class MyInputProcessor implements InputProcessor {
	
	GameController controller;
	
	public MyInputProcessor(GameController controller){
		this.controller = controller;
	}
	
   @Override
   public boolean keyDown (int keycode) {
      return false;
   }

   @Override
   public boolean keyUp (int keycode) {
      //Aqio
	  
      return false;
   }

   @Override
   public boolean keyTyped (char character) {
      return false;
   }

   @Override
   public boolean touchDown (int x, int y, int pointer, int button) {
	  controller.touch(new Vector3(x,480-y,0));
      return false;
   }

   @Override
   public boolean touchUp (int x, int y, int pointer, int button) {
      return false;
   }

   @Override
   public boolean touchDragged (int x, int y, int pointer) {
      return false;
   }

   public boolean touchMoved (int x, int y) {
      return false;
   }

   public boolean scrolled (int amount) {
      return false;
   }

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		// TODO Auto-generated method stub
		return false;
	}
}