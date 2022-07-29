package kr.co.hanbit.containerspinner

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kr.co.hanbit.containerspinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var data = listOf("- 선택하세요 -", "1월", "2월", "3월", "4월", "5월", "6월") //스피너에 입력될 가상의 데이터
        var adapter = ArrayAdapter<String>(
            this,
            R.layout.simple_list_item_1,
            data
        ) //데이터와 스피너를 연결시켜줄 ArrayAdapter 클래스를 만들어 변수에 저장
        /* ArrayAdapter
            파라미터 1: 스피너를 화면에 그리기 위한 컨텍스트 (this: MainActivity)
            파라미터 2: 스피너에 보여줄 목록 하나하나가 그려질 레이아웃
                (simple_list_item_1 레이아웃: 텍스트뷰 1개만을 가지고 있는 특수한 레이아웃
                ArrayAdapter와 같은 기본 어댑터에 사용하면 입력된 데이터에서 문자열 1개를 꺼내서 레이아웃에 그려줌)
            파라미터 3: 어댑터에서 사용할 데이터
         */

        binding.spinner.adapter = adapter //어댑터를 스피너 위젯에 연결
        binding.spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            // onItemSelectedListener: 스피너에 있는 아이템이 선택되면 동작하는 리스너
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //TODO("Not yet implemented")
                binding.result.text = data.get(position) //position: 사용자가 스피너에서 선택을 하면 몇 번째 아이템인지 알려주는 파라미타
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //TODO("Not yet implemented")
            }

        }
    }
}
