package com.koo.android.practice.rhinoapplication;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptableObject;

/**
 * Created by koo on 2015/08/12.
 */
public class RhinoSample {

    public void runJavaScript(String script)
    {
        Context context = Context.enter();
        context.setOptimizationLevel(-1); // use interpreter mode

        //target obj
        UtilsForRhino utils = new UtilsForRhino();
        try
        {
            ScriptableObject scope = context.initStandardObjects();
            String resultString = null;
            try
            {
                //set Function
                String[] funcNames = { "toast"};
                scope.defineFunctionProperties(funcNames, UtilsForRhino.class, ScriptableObject.DONTENUM);

                //set Object
                Object wrapped = Context.javaToJS(utils, scope);
                ScriptableObject.putProperty(scope, "utils", wrapped);

                //run
                Object result = context.evaluateString(scope, script, "<EditText>", 1, null);
                resultString = Context.toString(result);
            }
            catch (org.mozilla.javascript.RhinoException jse)
            {
                resultString = jse.toString();
            }
        }
        finally
        {
            Context.exit();
        }
    }
}
