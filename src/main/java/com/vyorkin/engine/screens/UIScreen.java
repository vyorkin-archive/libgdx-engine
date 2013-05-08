package com.vyorkin.engine.screens;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.vyorkin.engine.E;

public abstract class UIScreen extends StageScreen {
	private final String uiSkinPath;

	protected Skin skin;
	protected Table table;
	
	public UIScreen(String uiSkinPath) {
		super(E.settings.width, E.settings.height);
		
		this.uiSkinPath = uiSkinPath;
	}
	
	@Override
	public void show() {
		super.show();
		
		skin = E.assets.get(uiSkinPath, Skin.class);
		table = createTable();
		
		stage.addActor(table);
	}
	
	@Override
	public void draw(float delta) {
		super.draw(delta);
		
		if (E.preferences.isDeveloperMode())
			Table.drawDebug(stage);
	}
	
	private Table createTable() {
		Table table = new Table(skin);
        table.setFillParent(true);
        
        if (E.preferences.isDeveloperMode())
            table.debug();

        return table;
	}
	
	@Override
	public void dispose() {
		super.dispose();
		//skin.dispose();
	}	
}
