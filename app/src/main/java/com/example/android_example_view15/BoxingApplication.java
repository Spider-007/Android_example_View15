/*
 *  Copyright (C) 2017 Bilibili
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.android_example_view15;

import android.app.Application;

import com.example.android_example_view15.utils.BoxingGlideLoader;
import com.example.android_example_view15.loader.IBoxingMediaLoader;
import com.example.android_example_view15.utils.BoxingCrop;
import com.example.android_example_view15.utils.BoxingUcrop;

/**
 * aha, initial work.
 *
 * @author ChenSL
 */
public class BoxingApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        IBoxingMediaLoader loader = new BoxingGlideLoader();
        BoxingMediaLoader.getInstance().init(loader);
        BoxingCrop.getInstance().init(new BoxingUcrop());
    }
}
