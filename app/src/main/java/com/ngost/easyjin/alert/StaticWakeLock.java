/* Copyright 2014 Sheldon Neilson www.neilson.co.za
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */
package com.ngost.easyjin.alert;

import android.content.Context;
import android.os.PowerManager;

public class StaticWakeLock {
	public static PowerManager.WakeLock wl = null;

	public void lockOn(Context context) {
		PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
		//Object flags;
		PowerManager.WakeLock wl_func;
		if (wl == null){
			wl_func= pm.newWakeLock(PowerManager.FULL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "MATH_ALARM");
			wl_func.acquire();
			wl = wl_func;
		}

	}

	public static void lockOff() {
//		PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
		try {
			if (wl != null)
				wl.release();
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
}