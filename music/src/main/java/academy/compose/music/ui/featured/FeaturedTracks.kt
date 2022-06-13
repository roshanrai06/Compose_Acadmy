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
package academy.compose.music.ui.featured

import academy.compose.music.ContentFactory
import academy.compose.music.R
import academy.compose.music.Tags
import academy.compose.music.model.Track
import academy.compose.music.ui.new_tracks.NewTracks
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.chrisbanes.snapper.ExperimentalSnapperApi

@ExperimentalFoundationApi
fun LazyListScope.FeaturedTracks(
    tracks: List<Track>?,
    onTrackClicked: (track: Track) -> Unit
) {
    item {
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = stringResource(id = R.string.heading_featured),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        FeaturedTracksGrid(
            modifier = Modifier
                .fillMaxWidth()
                .testTag(Tags.TAG_FEATURED_TRACKS),
            tracks = tracks,
            onTrackClicked = { track ->
                onTrackClicked(track)
            }
        )
    }
}

@ExperimentalFoundationApi
@ExperimentalSnapperApi
@Preview(showBackground = true)
@Composable
fun Preview_NewTracks() {
    MaterialTheme {
        LazyColumn(
            contentPadding = PaddingValues(
                top = 12.dp,
                bottom = 8.dp
            ),
            content = {
            FeaturedTracks(tracks = ContentFactory.makeContentList(), onTrackClicked = {})
        })
    }
}