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
        try
        {
            ScriptableObject scope = context.initStandardObjects();
            String resultString = null;
            try
            {
                String[] funcNames = { "toast"};
                scope.defineFunctionProperties(funcNames, UtilsForRhino.class, ScriptableObject.DONTENUM);

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
