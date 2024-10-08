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
package academy.compose.graphs.ui

import academy.compose.graphs.model.GraphData
import academy.compose.graphs.model.GraphType
import academy.compose.graphs.ui.graph.AreaChart
import academy.compose.graphs.ui.graph.BarChart
import academy.compose.graphs.ui.graph.ColumnChart
import academy.compose.graphs.ui.graph.DoughnutChart
import academy.compose.graphs.ui.graph.LineChart
import academy.compose.graphs.ui.graph.PieChart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Chart(
    modifier: Modifier = Modifier,
    chart: GraphType,
    chartData: List<GraphData>
) {
    when (chart) {
        GraphType.PIE -> PieChart(modifier = modifier, chartData = chartData)
        GraphType.LINE -> LineChart(modifier = modifier, chartData = chartData)
        GraphType.BAR -> BarChart(modifier = modifier, chartData = chartData)
        GraphType.COLUMN -> ColumnChart(modifier = modifier, chartData = chartData)
        GraphType.DOUGHNUT -> DoughnutChart(modifier = modifier, chartData = chartData)
        GraphType.AREA -> AreaChart(modifier = modifier, chartData = chartData)
    }
}