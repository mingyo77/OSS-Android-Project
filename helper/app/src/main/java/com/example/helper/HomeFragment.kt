package com.example.helper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.helper.databinding.FragmentHomeBinding

class HomeFragment : Fragment(){

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // 2. 바인딩 초기화
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 3. MainActivity에서 보낸 Bundle 데이터(from_where) 받기
        val fromWhere = arguments?.getString("from_where")

        // 4. UI 테스트 (XML에 tvHomeTitle이라는 ID의 TextView가 있다면 아래처럼 확인 가능)
        // binding.tvHomeTitle.text = "현재 탭: $fromWhere"
    }
    override fun onDestroyView() {
        super.onDestroyView()
        // 5. 프래그먼트 파괴 시 바인딩 해제
        _binding = null
    }
}