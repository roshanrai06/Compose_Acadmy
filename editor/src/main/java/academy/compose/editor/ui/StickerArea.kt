/*
 * Copyright 2022 Compose Academy
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
package academy.compose.editor.ui

import academy.compose.editor.model.EditorObject
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.sp

@Composable
fun StickerArea(
    modifier: Modifier = Modifier,
    drawingObjects: List<EditorObject.Text>,
    onTransform: (id: String, offset: Offset, rotation: Float, scale: Float) -> Unit
) {
    Box(modifier = modifier) {
        drawingObjects.forEach { text ->
            Text(
                modifier = Modifier
                    .graphicsLayer {
                        rotationZ = text.rotation
                        scaleX = text.scale
                        scaleY = text.scale
                        translationX = text.offset.x
                        translationY = text.offset.y
                    }
                    .pointerInput(Unit) {
                        detectTransformGestures { _, pan, gestureZoom, gestureRotate ->
                            onTransform(
                                text.id!!,
                                Offset(pan.x, pan.y),
                                gestureRotate,
                                gestureZoom
                            )
                        }
                    },
                text = text.text,
                color = text.color,
                fontSize = 100.sp
            )
        }
    }
}