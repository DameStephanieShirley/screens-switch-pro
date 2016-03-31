package layout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.liyang.landanypro.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NextFragment extends Fragment {


    public NextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_next, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        //get layout id set value
        TextView tv = (TextView) view.findViewById(R.id.tv);
        if (getArguments().getString("text")!=null&&tv!=null) {
        tv.setText(getArguments().getString("text"));
        }

    }
}
