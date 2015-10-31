package sandbox;

import com.jme3.app.SimpleApplication;
import com.jme3.light.AmbientLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue.ShadowMode;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;

public class Main0 {

	public static void main(String[] args){
		AppSettings settings = new AppSettings(true);
		//settings.setResolution(1280, 720);
		//settings.setVSync(false);
		//settings.setFullscreen(false);
		//settings.setDepthBits(24);
		//settings.setGammaCorrection(true);
		settings.setRenderer(AppSettings.JOGL_OPENGL_FORWARD_COMPATIBLE);
		settings.setAudioRenderer(AppSettings.JOAL);
		SimpleApplication app = new SimpleApplication() {
			@Override
			public void simpleInitApp() {
			}
		};
		app.setSettings(settings);
		app.setShowSettings(false);
		//app.setDisplayFps(true);
		//app.setDisplayStatView(true);
		app.start();
		app.enqueue(()->{
			//scene0(app);
			scene1(app);
			//scene2(app);
			return true;
		});
	}

	public static void scene0(SimpleApplication app){
		Box b = new Box(1, 1, 1);
		Geometry geom = new Geometry("Box", b);
		Material mat = new Material(app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
		mat.setColor("Color", ColorRGBA.Blue);
		geom.setMaterial(mat);
		app.getRootNode().attachChild(geom);
	}

	public static void scene1(SimpleApplication app){
		Box b = new Box(1, 1, 1);
		Geometry geom = new Geometry("Box", b);
		Material mat = new Material(app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
		mat.setTexture("ColorMap", app.getAssetManager().loadTexture("Textures/crytek_sponza2/sponza_ceiling_a_diff.dds"));
		geom.setMaterial(mat);
		app.getRootNode().attachChild(geom);
	}

	public static void scene2(SimpleApplication app){
		Node scene = new Node("scene1");
		Spatial sponza = app.getAssetManager().loadModel("Models/crytek_sponza2.j3o");
		sponza.scale(10.0f);
		sponza.setShadowMode(ShadowMode.CastAndReceive);
		sponza.setLocalTranslation(new Vector3f(0f, -8f + 1.5f, 0f)); // -8 if the location of physical floor in Sample02 :-P
		scene.attachChild(sponza);

		scene.addLight(new AmbientLight(new ColorRGBA(0.1f, 0.1f, 0.04f, 1.0f)));
		app.getRootNode().attachChild(scene);
	}
}
