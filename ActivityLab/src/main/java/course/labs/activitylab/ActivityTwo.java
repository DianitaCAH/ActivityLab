package course.labs.activitylab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

    private static final String DESTROY_KEY = "destroy";
    private static final String PAUSE_KEY = "pause";
    private static final String STOP_KEY = "stop";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";

	// Lifecycle counters
    private int mCreate = 0;
    private int mResume = 0;
    private int mRestart = 0;
    private int mStart = 0;
    // Create counter variables for onCreate(), onRestart(), onStart() and
	// onResume(), called mCreate, etc.
	// You will need to increment these variables' values when their
	// corresponding lifecycle methods get called
    private TextView mTvCreate, mTvStart, mTvResume, mTvRestart;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

		Button closeButton = (Button) findViewById(R.id.bClose); 
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO:
                finish();
				// This function closes Activity Two
				// Hint: use Context's finish() method
			}
		});

		// Check for previously saved state
		if (savedInstanceState != null) {

			// TODO:
			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable
            savedInstanceState.getInt(String.valueOf(mCreate));
            savedInstanceState.getInt(String.valueOf(mRestart));
            savedInstanceState.getInt(String.valueOf(mResume));
            savedInstanceState.getInt(String.valueOf(mStart));
		}

        // TODO: Emit LogCat message
        Log.i(CREATE_KEY, "Entro en el OnCreate");

        // TODO:
        mCreate++;
        // Update the appropriate count variable
        // Update the user interface via the displayCounts() method
        displayCounts();
	}

	// Lifecycle callback methods overrides

	@Override
	public void onStart() {
		super.onStart();

        // TODO: Emit LogCat message
        Log.i(START_KEY, "Entro en el OnStart");

        // TODO:
        mStart++;
        // Update the appropriate count variable
        // Update the user interface
        displayCounts();

	}

	@Override
	public void onResume() {
		super.onResume();

        // TODO: Emit LogCat message
        Log.i(RESUME_KEY, "Entro en el OnResume");

        // TODO:
        mResume++;
        // Update the appropriate count variable
        // Update the user interface
        displayCounts();

	}

	@Override
	public void onPause() {
		super.onPause();

		// TODO: Emit LogCat message
        Log.i(PAUSE_KEY, "Entro en el OnPause");
	}

	@Override
	public void onStop() {
		super.onStop();

		// TODO: Emit LogCat message
        Log.i(STOP_KEY, "Entro en el OnStop");
	}

	@Override
	public void onRestart() {
		super.onRestart();

        // TODO: Emit LogCat message
        Log.i(RESTART_KEY, "Entro en el OnRestart");

        // TODO:
        mRestart++;
        // Update the appropriate count variable
        // Update the user interface
        displayCounts();

	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		// TODO: Emit LogCat message
        Log.i(DESTROY_KEY, "Entro en el OnDestroy");
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {

		// TODO:
		// Save counter state information with a collection of key-value pairs
		// 4 lines of code, one for every count variable
        savedInstanceState.putInt(CREATE_KEY, mCreate);
        savedInstanceState.putInt(RESTART_KEY, mRestart);
        savedInstanceState.putInt(RESUME_KEY, mResume);
        savedInstanceState.putInt(START_KEY, mStart);
	}

	// Updates the displayed counters
	public void displayCounts() {

        mTvCreate = (TextView)findViewById(R.id.onCreate2);
        mTvCreate.setText(getResources().getString(R.string.onCreate, mCreate));

        mTvStart = (TextView)findViewById(R.id.onStart2);
        mTvStart.setText(getResources().getString(R.string.onStart, mStart));

        mTvResume = (TextView)findViewById(R.id.onResume2);
        mTvResume.setText(getResources().getString(R.string.onResume, mResume));

        mTvRestart = (TextView)findViewById(R.id.onRestart2);
        mTvRestart.setText(getResources().getString(R.string.onRestart, mRestart));
	
	}
}
