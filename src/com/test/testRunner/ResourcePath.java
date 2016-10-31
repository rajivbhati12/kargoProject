/**
 * Created by rajivbhati on 10/30/16.
 * @description: Singleton class instance to help initialize resource path
 */
package com.test.testRunner;

public class ResourcePath {
    private static ResourcePath instance = null;
    private String path = "";
    protected ResourcePath() {
    }

    public void setPath(String path){
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }

    public static ResourcePath getInstance() {
        if(instance == null) {
            instance = new ResourcePath();
        }
        return instance;
    }
}
