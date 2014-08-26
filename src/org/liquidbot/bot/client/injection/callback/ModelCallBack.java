package org.liquidbot.bot.client.injection.callback;

import org.liquidbot.bot.script.api.wrappers.Model;

import java.util.Hashtable;

/**
 * Created by Hiasat on 8/23/14.
 */
public class ModelCallBack {

	private static Hashtable<Object, Model> modelCache = new Hashtable<>();

	public static void add(Model model, Object render) {
		if (render != null && model != null && model.isValid()) {
			if(modelCache.containsKey(render))
				modelCache.remove(render) ;
			modelCache.put(render, model);
		}
	}

	public static Model get(Object render) {
		if(render == null)
			return null;
		return modelCache.get(render);
	}

}
