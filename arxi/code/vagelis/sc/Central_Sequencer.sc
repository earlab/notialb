	
	Central_Sequencer{
	
		*load{
	
	
	
	
	//:After_Eisagogi_CENTRAL_SEQUENCER
	//:===================================================================
	
	//Note: All the durations of the Pbinds schould be 1 and then the Ppar can control the duration 		of the all pattern
	
	
	Pdef(\afterEisagogi, 
		
		Pseq([
			
		Pseq([ Pdef(\standart) ], 8),			//(1) // (8_Metra)
		
		Pseq([ Pdef(\clack) ], 2),				//(2) // (2_Metra)
		//(2)
		Pseq([ Pdef(\with_Bota_1_2) ], 4),		//(3) // (8_Metra)
		//(3.1)
		Pseq([ Pdef(\with_Noise2) ], 10),		//(4) // (10_Metra)
		//(3.2)
		Pseq([ Pdef(\with_Big_Noise2) ], 12),	  	//(5) // (12_Metra)
         //(3.3, 3.4)
		Pseq([ Pdef(\with_More_Bota_1_2) ], 12),	//(6) // (24_Metra)	
		Pseq([ Pdef(\high_Alone) ], 1),			//(7) // (2_Metra)

		(1/3) + (1/2) + (1/3) + (1/3) + (1/6 * 6) + (1/6)    //(8) // (1_Metra)
	
	
	], 1));
	
	Pdef(\afterEisagogi).quant = 0;
	//Pdef(\afterEisagogi).play;
	
	
	//:Meros_1o_CENTRAL_SEQUENCER  (6:23)
	//:===================================================================
	
	//Sum ( 132 Metra)
	
	Pdef(\meros_1o, 
		
		Pseq([
			
		Pseq( [ Pdef(\no_InFast_OnlyNoise_1) ], 1),	//(2) // (1_Metra)

		Pseq( [ Pdef(\no_InFast_OnlyNoise_2) ], 1),	//(2) // (1_Metra)
		
		Pseq( [ Pdef(\classic_1_2) ], 10),			//(1) // (20_Metra)
	
		Pseq( [ Pdef(\classic_3) ], 1),				//(1.1) // (1_Metra)
		
		Pseq( [ Pdef(\connector) ], 1),				//(x) // (1_Metra)
		
		Pseq( [ Pdef(\no_InFast_1_2) ], 2),			//(2) // (4_Metra)
		
		Pseq( [ Pdef(\high_Freq_InFast_1_2) ], 3),	//(3) // (6_Metra)
	
		Pseq( [ Pdef(\classic2_1_2_3_4) ], 3),		//(4) // (24_Metra)
	
		Pseq( [ Pdef(\no_Noise) ], 4),				//(5) // (8_Metra)
	
			Pseq( [ Pdef(\no_Noise_3) ], 1),			//(5.1) // (1_Metra)
		
		Pseq( [ Pdef(\high_Env) ], 8),				//(6) // (8_Metra)
	
		//Pseq( [ Pdef(\sinFB) ], 1) (49_Metra)					
			Pseq( [ Pdef(\sinFB_1) ], 3),			//(7.1) // (3_Metra)
		
			Pseq( [ Pdef(\sinFB_2) ], 2),			//(7.2) // (2_Metra)
		
			Pseq( [ Pdef(\sinFB_3) ], 2),			//(7.3) // (2_Metra)
		
			Pseq( [ Pdef(\sinFB_2) ], 2),			//(7.2) // (2_Metra)
			
			Pseq( [ Pdef(\sinFB_4) ], 2),			//(7.4) // (2_Metra)
	
			Pseq( [ Pdef(\sinFB_3) ], 2),			//(7.3) // (2_Metra)
	
			Pseq( [ Pdef(\sinFB_2) ], 3),			//(7.2) // (3_Metra)
			
			Pseq( [ Pdef(\sinFB_4) ], 5),			//(7.4) // (5_Metra)
	
			Pseq( [ Pdef(\sinFB_2) ], 4),			//(7.2) // (4_Metra)
	
			Pseq( [ Pdef(\sinFB_4) ], 15),			//(7.4) // (15_Metra)
	
			Pseq( [ Pdef(\sinFB_5) ], 3),			//(7.5) // (3_Metra)
	
			Pseq( [ Pdef(\sinFB_6) ], 3),			//(7.6) // (3_Metra)

			Pseq( [ Pdef(\sinFB_2_1) ], 1),			//(7.6) // (1_Metra)
	
			Pseq( [ Pdef(\sinFB_5) ], 1),			//(7.5) // (1_Metra)
	
			Pseq( [ Pdef(\sinFB_6) ], 1)			//(7.6) // (1_Metra)

	], 1));
		
	//:
	
	Pdef(\meros_1o).quant = 0;
	//Pdef(\meros_1o).play;
	//Pdef(\meros_1o).stop;
	
		
		
	//:Meros_2o_CENTRAL_SEQUENCER
	//:===================================================================
	
	//Sum ( Mia Fora: 34 Metra) Sto 33 stamataei
	
	Pdef(\meros_2o, 
		
		Pseq([
			
		Pseq( [ Pdef(\arxi_Meros_2) ], 1),		//(arxi) //4_Metra
		
		Pseq( [ Pdef(\standart_Meros_2) ], 5),	//(1) //5 

		Pseq( [ Pdef(\standart2_Meros_2) ], 2),	//(2) //4
		
		Pseq( [ Pdef(\more_Bota_Meros_2) ], 4),	//(3) //8
		
		Pseq( [ Pdef(\More_Rand_Meros_2) ], 4),	//(4) //8	
		Pseq( [ Pdef(\More_Rand_2_Meros_2) ], 4), //(5) //8
		//2
		Pseq( [ Pdef(\standart_Meros_2) ], 4),	//(1) //4

		Pseq( [ Pdef(\standart2_Meros_2) ], 2),	//(2) //4
		
		Pseq( [ Pdef(\more_Bota_Meros_2) ], 4),	//(3) //8
		
		Pseq( [ Pdef(\More_Rand_Meros_2) ], 4),	//(3) //8	
		Pseq( [ Pdef(\More_Rand_2_Meros_2) ], 4) //(5) //8
		
		//Pseq( [ Pdef(\more_Bota_Meros_2) ], 2)

	], 1));	
		
	Pdef(\meros_2o).quant = 0;	
		
		
		
		
		}
	
	}