package com.example.android.islamic;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;

    static Boolean web= true;
    public static boolean nightmode = true;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

//
//                if(nightmode == true) {
//
//
//                    fab.setRippleColor(Color.BLACK);
//                    fab.setImageResource(R.drawable.ic_action_sun);
////                    Toast.makeText(getApplicationContext() ,"NightMode",Toast.LENGTH_LONG).show();
//                            nightmode =false;
//
//                        }
//                        else
//                        {
//                            fab.setRippleColor(Color.WHITE);
//                            fab.setImageResource(R.drawable.moonnew);
//                            Toast.makeText(getApplicationContext() ,"DayMode",Toast.LENGTH_LONG).show();
//                            nightmode =true;
//                        }


                try {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                    String sAux = "\nLet me recommend you this application\n\n";
//                    sAux = sAux + "https://play.google.com/store/apps/details?id=Orion.Soft \n\n";
                    i.putExtra(Intent.EXTRA_TEXT, sAux);
                    startActivity(Intent.createChooser(i, "choose one"));
                } catch(Exception e) {
                    e.printStackTrace();
                }

            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */



        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                                 Bundle savedInstanceState) {



           if(getArguments().getInt(ARG_SECTION_NUMBER)==1) {

               final View rootview  = inflater.inflate(R.layout.fragment_fundamentals ,container,false);

               TextView tv  =(TextView) rootview.findViewById(R.id.textview_for_importance);
               tv.setText("The two fundamental sources of Islam are the Qur’an (the word of God) and the Sunnah (the example) of the Prophet (peace and blessings be upon him). By Sunnah, we mean the actions, sayings and silent permissions (or disapprovals) of the Prophet." +
                       "The word “Sunnah” is also used to refer to religious duties that are optional. Here, we are concerned with Sunnah in the sense of the recorded sayings (Hadiths) of Prophet Muhammad (peace and blessings be upon him)." +
                       "In this sense, Hadith is considered to be second to the Qur’an. It is impossible to understand the Qur’an without reference to the Hadith; and it is impossible to explain a hadith without relating it to the Qur’an." +
                       "The Qur’an is the message, while the Hadith is the verbal translation of the message into pragmatic terms, as exemplified by the Prophet. While the Qur’an is the metaphysical basis of the Sunnah, the Sunnah is the practical demonstration of the precepts laid down in the Qur’an." +
                       "The duty of the Messenger was not just to communicate the message, rather, he was entrusted with the most important task of explaining and illustrating that message. That is the reason why Allah Himself has commanded the following:" +
                       "{Say: Obey Allah and obey the Messenger, but if you turn away, he (the Prophet) is only responsible for the duty placed on him (i.e. to convey Allah’s Message) and you for that placed on you. If you obey him, you shall be on the right guidance. The Messenger’s duty is only to convey (the message) in a clear way.} (An-Nur 24:54)\n" +
                       "This verse clearly tells us the overriding importance of Hadith to Muslims. They should be eager to learn and follow the teachings of the Prophet as expressed in Hadith. If we are negligent in this respect, it is we who have to answer before Allah.");

               Button b1 = (Button) rootview.findViewById(R.id.button_view_for_importance);

               b1.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {


                       WebView webView = (WebView) rootview.findViewById(R.id.my_web_view);
                       webView.getSettings().setJavaScriptEnabled(true);
                       if(web == true) {
                           webView.setVisibility(View.VISIBLE);
                           webView.loadUrl("http://aboutislam.net/shariah/hadith/hadith-faqs/why-hadith-is-important/");
                           webView.getSettings().setBuiltInZoomControls(true);

                           web = false;

                       }
                       else
                       {
                           webView.setVisibility(View.GONE);
                           web  = true;
                       }

//                       webView.setInitialScale(50);

//                       Intent i = new Intent(Intent.ACTION_VIEW , Uri.parse("http://aboutislam.net/shariah/hadith/hadith-faqs/why-hadith-is-important/"));
//                       startActivity(i);
                   }
               });




               return rootview;
           }
            else if(getArguments().getInt(ARG_SECTION_NUMBER)==2) {

                View rootview  = inflater.inflate(R.layout.fragment_hadees ,container,false);

               ArrayList<AndroidFlavourHadeesAdapter> al = new ArrayList<AndroidFlavourHadeesAdapter>();
               al.add(new AndroidFlavourHadeesAdapter("Hadees text" ,"hadees text" ,R.drawable.pin));
               al.add(new AndroidFlavourHadeesAdapter("Hadees text" ,"hadees text" ,R.drawable.pin));
               al.add(new AndroidFlavourHadeesAdapter("Hadees text" ,"hadees text" ,R.drawable.pin));
               al.add(new AndroidFlavourHadeesAdapter("Hadees text" ,"hadees text" ,R.drawable.pin));
               al.add(new AndroidFlavourHadeesAdapter("Hadees text" ,"hadees text" ,R.drawable.pin));
               al.add(new AndroidFlavourHadeesAdapter("Hadees text" ,"hadees text" ,R.drawable.pin));
               al.add(new AndroidFlavourHadeesAdapter("Hadees text" ,"hadees text" ,R.drawable.pin));
               al.add(new AndroidFlavourHadeesAdapter("Hadees text" ,"hadees text" ,R.drawable.pin));
               al.add(new AndroidFlavourHadeesAdapter("Hadees text" ,"hadees text" ,R.drawable.pin));
               al.add(new AndroidFlavourHadeesAdapter("Hadees text" ,"hadees text" ,R.drawable.pin));
               al.add(new AndroidFlavourHadeesAdapter("Hadees text" ,"hadees text" ,R.drawable.pin));
               al.add(new AndroidFlavourHadeesAdapter("Hadees text" ,"hadees text" ,R.drawable.pin));
               al.add(new AndroidFlavourHadeesAdapter("Hadees text" ,"hadees text" ,R.drawable.pin));
               ListView lv = (ListView) rootview.findViewById(R.id.listview);


               AndroidFlavour an  = new AndroidFlavour(getActivity() ,al);

               lv.setAdapter(an);


                return rootview;
            }
            else if(getArguments().getInt(ARG_SECTION_NUMBER)==3) {


               final TimePicker tp;
               Button b1;

               View rootview  = inflater.inflate(R.layout.fragment_notifier ,container,false);
               tp = (TimePicker)  rootview.findViewById(R.id.timePicker);
               b1 = (Button) rootview.findViewById(R.id.butonnsetNotification);


               b1.setOnClickListener(new View.OnClickListener() {
                   @RequiresApi(api = Build.VERSION_CODES.M)
                   @Override
                   public void onClick(View view) {

                       Calendar cl = Calendar.getInstance();

                       if(Build.VERSION.SDK_INT >= 23) {
                           cl.set(
                                   cl.get(Calendar.YEAR),
                                   cl.get(Calendar.MONTH),
                                   cl.get(Calendar.DAY_OF_MONTH),
                                   tp.getHour(),
                                   tp.getMinute(),
                                   0

                           );
                       }
                       else
                       {

                           cl.set(
                                   cl.get(Calendar.YEAR),
                                   cl.get(Calendar.MONTH),
                                   cl.get(Calendar.DAY_OF_MONTH),
                                   tp.getCurrentHour(),
                                   tp.getCurrentMinute(),
                                   0

                           );

                       }


                           setAlarm(cl.getTimeInMillis());
                   }
               });

               return rootview;
            }
           else
           {
               View rootView = inflater.inflate(R.layout.fragment_main, container, false);
               TextView textView = (TextView) rootView.findViewById(R.id.section_label);
               textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
               return rootView;
           }

        }

        public   void setAlarm(long timeInMillis) {

            int ini =1;
            long temp = timeInMillis - 24000;

            AlarmManager al = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);

            Intent i = new Intent(getContext(), BlankFragment.class);
            PendingIntent pi = PendingIntent.getBroadcast(getContext() ,0 ,i ,0);


            al.setRepeating(AlarmManager.RTC_WAKEUP , temp ,2000,pi);

            Toast.makeText(getContext(),"Notification has set",Toast.LENGTH_LONG).show();
        }


    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }
}
