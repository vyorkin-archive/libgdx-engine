package com.vyorkin.engine.screens;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.vyorkin.engine.E;

public abstract class UIScreen extends StageScreen {
	private final String uiSkinPath;
	protected final boolean isDeveloperMode;

	protected Skin skin;
	protected Table table;
	
	public UIScreen(String uiSkinPath) {
		super(E.settings.width, E.settings.height);
		
		this.uiSkinPath = uiSkinPath;
		this.isDeveloperMode = E.preferences.isDeveloperMode();
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
		
		if (isDeveloperMode)
			Table.drawDebug(stage);
	}
	
	@Override
	public void dispose() {
		super.dispose();
		skin.dispose();
	}
	
	private Table createTable() {
		Table table = new Table(skin);
        table.setFillParent(true);
        
        if (isDeveloperMode)
            table.debug();

        return table;
	}
}
