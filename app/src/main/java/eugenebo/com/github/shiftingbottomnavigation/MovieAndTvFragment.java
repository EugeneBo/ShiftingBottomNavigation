package eugenebo.com.github.shiftingbottomnavigation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.arlib.floatingsearchview.FloatingSearchView;

public class MovieAndTvFragment extends Fragment {

    private static boolean fragmentFirstStartFlag = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_movie_and_tv, container, false);
        FloatingSearchView fsv = v.findViewById(R.id.floating_search_view);

        if (fragmentFirstStartFlag) {
            fsv.setSearchHint("Search...");
            fragmentFirstStartFlag = false;
        } else {
            fsv.setSearchHint(getString(R.string.movie_and_tv_title));
        }
        return v;
    }

    public static void setFragmentFirstStartFlag(boolean state) {
        fragmentFirstStartFlag = state;
    }

}
