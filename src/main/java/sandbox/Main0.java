package sandbox;

import com.jme3.app.SimpleApplication;
import com.jme3.system.AppSettings;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.math.ColorRGBA;

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
          scene0(app);
          return true;
        });
    }

    public static void scene0(SimpleApplication app){
        Box b = new Box(1, 1, 1); // create cube shape
        Geometry geom = new Geometry("Box", b);  // create cube geometry from the shape
        Material mat = new Material(app.getAssetManager(),
          "Common/MatDefs/Misc/Unshaded.j3md");  // create a simple material
        mat.setColor("Color", ColorRGBA.Blue);   // set color of material to blue
        geom.setMaterial(mat);                   // set the cube's material
        app.getRootNode().attachChild(geom);              // make the cube appear in the scene
    }
}
