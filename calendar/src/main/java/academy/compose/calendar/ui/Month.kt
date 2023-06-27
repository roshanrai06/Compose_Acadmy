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
package academy.compose.calendar.ui

import academy.compose.calendar.EventFactory
import academy.compose.calendar.Tags.TAG_MONTH
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.*

@Composable
fun Month(
    modifier: Modifier = Modifier,
    date: Calendar
) {
    Column(
        modifier = modifier.testTag(TAG_MONTH),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        (0 until 6).forEach { columnPosition ->
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
            )
            val dateForMonthCell = date.clone() as Calendar
            dateForMonthCell.add(
                Calendar.WEEK_OF_YEAR,
                columnPosition
            )
            WeekRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .testTag(dateForMonthCell.get(Calendar.WEEK_OF_YEAR).toString()),
                calendarWeek = dateForMonthCell,
                EventFactory.events
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_Month() {
    Month(
        modifier = Modifier.fillMaxSize(),
        date = Calendar.getInstance()
    )
}