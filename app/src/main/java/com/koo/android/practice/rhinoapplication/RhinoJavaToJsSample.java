package com.koo.android.practice.rhinoapplication;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

/**
 * Created by koo on 2015/08/12.
 */
public class RhinoJavaToJsSample {

    public void runJavaScript(String script)
    {
        Context context = Context.enter();
        context.setOptimizationLevel(-1); // use interpreter mode

        UtilsForRhino utils = new UtilsForRhino();
        try
        {
            Scriptable scope = context.initStandardObjects();
            try
            {
                Object wrapped = Context.javaToJS(utils, scope);
                ScriptableObject.putProperty(scope, "utils", wrapped);

                context.evaluateString(scope, script, "script", 1, null);
            }
            catch (org.mozilla.javascript.RhinoException jse)
            {
                jse.printStackTrace();
            }
        }
        finally
        {
            Context.exit();
        }
    }
}
