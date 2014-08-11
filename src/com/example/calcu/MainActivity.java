package com.example.calcu;

//import com.example.acalculadora.R;
import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

	private Button boton0, boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9,
    botonMas, botonMenos, botonPor, botonDiv, botonIgual, botonLimpiar, botonMas_Menos;
	EditText Campo;
	private boolean ultimoPresionadoNumero;
	private boolean ultimoPresionadoOperacion;
	String UltOp= "ninguna";
	double mente = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        boton0 = (Button) findViewById(R.id.boton0);
		boton1 = (Button) findViewById(R.id.boton1);
		boton2 = (Button) findViewById(R.id.boton2);
		boton3 = (Button) findViewById(R.id.boton3);
		boton4 = (Button) findViewById(R.id.boton4);
		boton5 = (Button) findViewById(R.id.boton5);
		boton6 = (Button) findViewById(R.id.boton6);
		boton7 = (Button) findViewById(R.id.boton7);
		boton8 = (Button) findViewById(R.id.boton8);
		boton9 = (Button) findViewById(R.id.boton9);
		botonMas = (Button) findViewById(R.id.botonMas);
		botonMenos = (Button) findViewById(R.id.botonMenos);
		botonPor = (Button) findViewById(R.id.botonPor);
		botonDiv = (Button) findViewById(R.id.botonDiv);
		botonIgual = (Button) findViewById(R.id.botonIgual);
		botonLimpiar = (Button) findViewById(R.id.botonLimpiar);
		botonMas_Menos = (Button) findViewById(R.id.botonMas_Menos);
		Campo = (EditText) findViewById(R.id.Campo);
		
		boton0.setTag("NUM");
		boton1.setTag("NUM");
		boton2.setTag("NUM");
		boton3.setTag("NUM");
		boton4.setTag("NUM");
		boton5.setTag("NUM");
		boton6.setTag("NUM");
		boton7.setTag("NUM");
		boton8.setTag("NUM");
		boton9.setTag("NUM");
		botonDiv.setTag("DIV");
		botonIgual.setTag("IGUAL");
		botonLimpiar.setTag("LIM");
		botonMas.setTag("SUM");
		botonMenos.setTag("RES");
		botonPor.setTag("MUL");
		botonMas_Menos.setTag("SIG");
		
		boton0.setOnClickListener(this);
		boton1.setOnClickListener(this);
		boton2.setOnClickListener(this);
		boton3.setOnClickListener(this);
		boton4.setOnClickListener(this);
		boton5.setOnClickListener(this);
		boton6.setOnClickListener(this);
		boton7.setOnClickListener(this);
		boton8.setOnClickListener(this);
		boton9.setOnClickListener(this);
		botonDiv.setOnClickListener(this);
		botonIgual.setOnClickListener(this);
		botonLimpiar.setOnClickListener(this);
		botonMas.setOnClickListener(this);
		botonMenos.setOnClickListener(this);
		botonPor.setOnClickListener(this);
		botonMas_Menos.setOnClickListener(this);
		
		Campo.setText("0");
		
    }
	@Override
	public void onClick(View v) {
		if ((String)v.getTag() == "NUM"){
			Button b = (Button)v;
			String numero = (String) b.getText();
			if (ultimoPresionadoNumero){
				if (Campo.getText().equals("0")){
					Campo.setText(numero);
				}else{
					Campo.setText(Campo.getText() + numero);
				}
			}else{
				Campo.setText(numero);
			}
			
			ultimoPresionadoNumero = true;
			ultimoPresionadoOperacion = false;
		}else
		{
			if((String)v.getTag() == "SUM")
			{
				if(UltOp=="ninguna"||ultimoPresionadoOperacion)
				{
					UltOp="SUM";
					mente=Double.parseDouble(Campo.getText().toString());
				}else
				{
					opera();
					UltOp="SUM";
					mente=Double.parseDouble(Campo.getText().toString());
				}
				ultimoPresionadoNumero = false;
				ultimoPresionadoOperacion = true;
			}else{
				if((String)v.getTag() == "RES")
				{
					if(UltOp=="ninguna"||ultimoPresionadoOperacion)
					{
						UltOp="RES";
						mente=Double.parseDouble(Campo.getText().toString());
					}else
					{
						opera();
						UltOp="RES";
						mente=Double.parseDouble(Campo.getText().toString());
					}
					ultimoPresionadoNumero = false;
					ultimoPresionadoOperacion = true;
				}
				else{
					if((String)v.getTag() == "MUL")
					{
						if(UltOp=="ninguna"||ultimoPresionadoOperacion)
						{
							UltOp="MUL";
							mente=Double.parseDouble(Campo.getText().toString());
						}else
						{
							opera();
							UltOp="MUL";
							mente=Double.parseDouble(Campo.getText().toString());
						}
						ultimoPresionadoNumero = false;
						ultimoPresionadoOperacion = true;
					}
					else{
						if((String)v.getTag() == "DIV")
						{
							if(UltOp=="ninguna"||ultimoPresionadoOperacion)
							{
								UltOp="DIV";
								mente=Double.parseDouble(Campo.getText().toString());
							}else
							{
								opera();
								UltOp="DIV";
								mente=Double.parseDouble(Campo.getText().toString());
							}
							ultimoPresionadoNumero = false;
							ultimoPresionadoOperacion = true;
						}else
						{
							if((String)v.getTag() == "IGUAL" && ultimoPresionadoNumero)
							{
								opera();
								UltOp="ninguna";
								mente=Double.parseDouble(Campo.getText().toString());
								ultimoPresionadoNumero = false;
								
							}else
							{
								if((String)v.getTag() == "LIM")
								{
									UltOp="ninguna";
									Campo.setText("0");
									ultimoPresionadoNumero = false;
									
									
								}else
								{
									if((String)v.getTag() == "SIG")
									{
										if(!Campo.getText().toString().contains(".")){
											Campo.setText(Campo.getText() + ".");
										}
										
										
									}
									
								}
																
							}
						}
					}
				}
			}
		}
		
		
	}
	public int opera(){
		double u;
		if(UltOp=="SUM")
		{
			u= mente + Double.parseDouble(Campo.getText().toString());
			String h = u+"";
			Campo.setText(h);
			
		}
		if(UltOp=="RES")
		{
			u= mente - Double.parseDouble(Campo.getText().toString());
			Campo.setText(""+u);
		}
		if(UltOp=="DIV")
		{
			u= mente / Double.parseDouble(Campo.getText().toString());
			Campo.setText(""+u);
		}
		if(UltOp=="MUL")
		{
			u= mente * Double.parseDouble(Campo.getText().toString());
			Campo.setText(""+u);
		}
		return 0;
	}
}
