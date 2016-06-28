
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import net.hockeyapp.android.CrashManager;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

public class YourActivity extends Activity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // Your own code to create the view
    // ...

    checkForUpdates();
  }

  @Override
  public void onResume() {
    super.onResume();
    // ... your own onResume implementation
    checkForCrashes();
  }

  @Override
  public void onPause() {
    super.onPause();
    unregisterManagers();
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    unregisterManagers();
  }

  private void checkForCrashes() {
    CrashManager.register(this);
  }

  private void checkForUpdates() {
    // Remove this for store builds!
    UpdateManager.register(this);
  }

  private void unregisterManagers() {
    UpdateManager.unregister();
  }
}
}

