package com.membership.kt.howlhellocharts

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import lecho.lib.hellocharts.gesture.ZoomType
import lecho.lib.hellocharts.model.Axis
import lecho.lib.hellocharts.model.Column
import lecho.lib.hellocharts.model.ColumnChartData
import lecho.lib.hellocharts.model.SubcolumnValue
import lecho.lib.hellocharts.util.ChartUtils

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var columns = ArrayList<Column>()

        for(i in 0..3){
            var values = ArrayList<SubcolumnValue>()
            for(j in 0..7){
                values.add(SubcolumnValue(Math.random().toFloat()* 50f,ChartUtils.pickColor()))
            }
            var column = Column(values)
            columns.add(column)
        }
        var data = ColumnChartData(columns)


        chart.zoomType = ZoomType.HORIZONTAL_AND_VERTICAL

        var axisX = Axis()
        var axisY = Axis()

        axisX.name = "Axis X"
        axisY.name = "Axis Y"

        data.axisXBottom = axisX
        data.axisYLeft = axisY
        data.isStacked = true
        chart.columnChartData = data
    }
}
