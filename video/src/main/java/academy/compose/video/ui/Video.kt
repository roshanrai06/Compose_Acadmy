/*
 * Copyright 2021 Compose Academy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package academy.compose.video.ui

import academy.compose.video.VideoViewModel
import academy.compose.video.ui.VideoPlayer
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun Video(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
) {
    val viewModel: VideoViewModel = viewModel()

    VideoPlayer(
        modifier = Modifier.fillMaxSize(),
        videoState = viewModel.uiState.collectAsState().value,
        lifecycleOwner = lifecycleOwner,
        handleEvent = viewModel::handleEvent
    )
}
