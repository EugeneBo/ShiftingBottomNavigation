package eugenebo.com.github.shiftingbottomnavigation;


import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final BottomNavigationView bnv = findViewById(R.id.bottom_navigation);

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {



                switch (item.getItemId()) {
                    case R.id.action_movie_and_tv:
                        fragment = setFragment(R.color.bottomNavBackground_MoviesAndTv, bnv, new MovieAndTvFragment());
                        break;
                    case R.id.action_music:
                        fragment = setFragment(R.color.bottomNavBackground_Music, bnv, new MusicFragment());
                        break;
                    case R.id.action_books:
                        fragment = setFragment(R.color.bottomNavBackground_Books, bnv, new BooksFragment());
                        break;
                    case R.id.action_newsstand:
                        fragment = setFragment(R.color.bottomNavBackground_News, bnv, new NewsFragment());
                        break;
                }

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                ft.replace(R.id.fragment_container, fragment)
                        .commit();

                return true;
            }
        });


        if (savedInstanceState == null) {
            bnv.setSelectedItemId(R.id.action_movie_and_tv); // here we put fragment on startup
            MovieAndTvFragment.setFragmentFirstStartFlag(true);

        }

    }


    private void changeStatusBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(color));
        }
    }

    public Fragment setFragment(int color, BottomNavigationView bnv, Fragment fragment) {
        changeStatusBarColor(color);
        bnv.setBackgroundResource(color);
        return fragment;
    }

}
