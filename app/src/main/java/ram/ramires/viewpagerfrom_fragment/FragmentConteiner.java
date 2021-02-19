package ram.ramires.viewpagerfrom_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class FragmentConteiner extends Fragment {
    private String [] titleList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_conteiner, container, false);
        titleList=getResources().getStringArray(R.array.title);
        ViewPager2 viewPager=view.findViewById(R.id.pager);
        FragmentStateAdapter adapter=new ViewPagerAdapter(requireActivity());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout=view.findViewById(R.id.tabs);
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(titleList[position]);
            }
        }).attach();


        return view;
    }
}