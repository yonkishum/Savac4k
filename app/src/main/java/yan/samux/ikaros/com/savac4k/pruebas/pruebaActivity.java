package yan.samux.ikaros.com.savac4k.pruebas;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.view.CardListView;
import it.gmariotti.cardslib.library.view.CardView;
import yan.samux.ikaros.com.savac4k.R;

public class pruebaActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prueba);

		//CardView cardView = (CardView) findViewById(R.id.card);

		Card card = new Card(this, R.layout.carta); // this คือ Context
		//cardView.setCard(card);

		ArrayList<Card> cards = new ArrayList<Card>();

		for (int i = 0; i < 5; i++) {
			Card c = new Card(this);
			c.setTitle("Title #" + i);
			cards.add(c);
		}

		CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(this, cards);

		CardListView listView = (CardListView) findViewById(R.id.card_list);
		if (listView != null) {
			listView.setAdapter(mCardArrayAdapter);
		}

		CardHeader cardHeader = new CardHeader(this);
		cardHeader.setTitle("This is header");

		card.setTitle("This is Title of Card");
		card.addCardHeader(cardHeader);

	}
}
