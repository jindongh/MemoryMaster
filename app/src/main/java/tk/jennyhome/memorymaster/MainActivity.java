package tk.jennyhome.memorymaster;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private Bundle bundle = new Bundle();
    private Fragment trainFragment = TrainFragment.newInstance(bundle);
    private Fragment historyFragment = HistoryFragment.newInstance(bundle);
    private Fragment settingFragment = SettingFragment.newInstance(bundle);

    private void loadFragment(int id) {
        Fragment fragment = null;
        switch(id) {
            case R.id.navigation_home:
                fragment = trainFragment;
                break;
            case R.id.navigation_dashboard:
                fragment = historyFragment;
                break;
            case R.id.navigation_notifications:
                fragment = settingFragment;
                break;
        }
        if (fragment == null)
            return;
        this.getFragmentManager().beginTransaction()
                .replace(R.id.content, fragment)
                .commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            loadFragment(item.getItemId());
            return true;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(R.id.fragment_train);
    }

}
