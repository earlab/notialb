/*
SendTags class. Modify PsendReceive Class.

_______________
| earlab team |
---------------

Iannis Zannos
Dakis Trentos
Omer Chatziserif
Aris Bezas
Alexandros Aggelakis
Vaggelis Tsatsis


----example-------

~test = SendTags.new;
~test.dests = [Dests.vagosAddr, Dests.arisAddr, Dests.alexAddr];
~test.title = '/tags';
~test.tags = [1, 2, 3, 4];
~test.step = [0.50];
~test.times = inf;
~test.loop;
~test.stop;
~test.atEnd

~testResp1 = RespTags.do('/tags', 1, nil);
~testResp1.action = {"testTag: 1".postln};
*/

Dests { classvar <>vagosAddr, <>alexAddr, <>arisAddr;
	*initClass {
		StartUp.add{
			//vagosAddr = NetAddr("169.254.47.198", 57120);
			//alexAddr = NetAddr("169.254.47.198", 57120);
			//arisAddr = NetAddr("169.254.45.129", 57120);

			// Add this false address because I am taking the error messages to Post window
			// if I am sending to IP that doesn't exist.
			vagosAddr = NetAddr("localhost", 57140);
			alexAddr = NetAddr("localhost", 57140);
			arisAddr = NetAddr.localAddr;
		}
	}
}

SendTags {
	var <>num=0, <>tags, <>step=0.25, <>title, <>steppattern, <>tagPat, task, verbose = true;
	var  <>dests, <>tag, <>tagg, <>stp, <>stp2, <>x, <>times = inf;
	var tag2;
	immediate {
		verbose = true;
	}
	atEnd {
		verbose = false;
	}
	loop {

		tagPat = PatternProxy(Pseq([nil], inf));
		steppattern = PatternProxy(Pseq([nil], inf));
		~tagSync = PatternProxy(Pseq([nil], inf));
		tagg = tagPat.asStream;
		stp = steppattern.asStream;
		task = Task({
			times.do{
				tagPat.source = Pseq(tags, inf);
				steppattern.source = Pseq(step, inf);
				~tagSync.source = Pseq(step, inf).asStream;

				// AB: -Poia i diafora tou verbose?
				verbose.switch(
					true, {
						num = tags.numChannels;
						num.do{
							x = tagg.next;
							// Apostoli s' oles tiw dieuthinseis
							dests do: _.sendMsg(title.asString, x);
							stp.next.wait;
						}
					},
					false, {
						steppattern.source = Pseq([step], inf);
						~tagSync.source = Pseq([step], inf).asStream;
						num.do{
							x = tagg.next;
							stp = steppattern.asStream;
							stp = ~tagSync.asStream;
							// Apostoli s' oles tiw dieuthinseis
							dests do: _.sendMsg(title.asString, x);
							stp.next.wait;
						}
					}
				)
			}
		});
		task.start;
	}
	pause {
		task.pause;
	}
	resume {
		task.resume;
	}
	reset {
		task.reset;
	}
	stop {
		task.stop;
	}
}


RespTags { var <>title, <>tag, <>action, <>responder;
	// <> Gia na dilonontai apo exo san sendTags.scd me .title ktl
	var addResp;
	*do { |title, tag, action, responder|
		^super.newCopyArgs(title, tag, action, responder).addResp;
	}
	addResp {
		responder = OSCresponderNode(nil, title.asString, {arg time, resp, msg;
			msg[1].switch( tag,
				action
			);
		}).add;
	}
	removeResp {
		responder.remove;
	}
}

RespClockTags { var <>title, <>tags, <>actions, <>numTags1, <>numTags2, num = 0;
	addResp {
		numTags1 = tags.size;
		fork{
			numTags1.do{
				OSCresponderNode(nil, title.asString, {arg time, resp, msg; /*msg[1].postln;*/
					msg[1].switch( tags[num],
						actions[num]
					);
				}).add;
				num.postln;
				num = num + 1;
				//numTags = numTags;
			}
		};
		fork{
			inf.do{
				var count;
				numTags2 = tags.size;
				if((numTags2 != numTags1) && (numTags2 > numTags1),
					{ count = numTags2 - numTags1;
						count.do{
							OSCresponderNode(nil, title.asString, {arg time, resp, msg;
								msg[1].switch( tags[num],
									actions[num]
								);
							}).add;
							num.postln;
							num = num + 1;
						};
					},
					{  }
				);
				0.001.wait;
			}
		};
	}
}
