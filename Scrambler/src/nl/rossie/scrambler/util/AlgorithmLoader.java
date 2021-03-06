package nl.rossie.scrambler.util;

import java.util.ArrayList;

import nl.rossie.scrambler.model.Scrambler;
import nl.rossie.scrambler.model.Solution;

public class AlgorithmLoader {

	public static void loadAlgs(Scrambler scrambler){
	
		boolean marcelDisabled = true;
		
		ArrayList<Solution> solutionsOLL = scrambler.getSolutionsOLL();
		
		solutionsOLL.add(new Solution("R U2 R2' F R F' U2 R' F R F'","Dot Runaway OLL1", true));
		solutionsOLL.add(new Solution("F R U R' U' F' f R U R' U' f'","Dot Zamboni OLL2", true));
		solutionsOLL.add(new Solution("f R U R' U' f' U F R U R' U' F'","Anti Nazi OLL3", true));
		solutionsOLL.add(new Solution("f R U R' U' f' U' F R U R' U' F'","Nazi OLL4", true));
		solutionsOLL.add(new Solution("r' U2 R U R' U r","Wide Anti Sune OLL5", true));
		solutionsOLL.add(new Solution("r U2 R' U' R U' r'","Wide Anti Sune OLL6", true));
		solutionsOLL.add(new Solution("r U R' U R U2 r'","Wide Sune OLL7", true));
		solutionsOLL.add(new Solution("l' U' L U' L' U2 l","Left Wide Sune OLL8", true));
		solutionsOLL.add(new Solution("R' U' R y' x' R U' R' F R U R' x","Fish OLL9", marcelDisabled));
		solutionsOLL.add(new Solution("R U R' y R' F R U' R' F' R","Fish OLL10", marcelDisabled));
		solutionsOLL.add(new Solution("F' L' U' L U F y F R U R' U' F'","Lightening bolt OLL11", marcelDisabled));
		solutionsOLL.add(new Solution("F R U R' U' F' U F R U R' U' F'","Lightening bolt OLL12", marcelDisabled));
		solutionsOLL.add(new Solution("F U R U2 R' U' R U R' F'","Knight OLL13", marcelDisabled));
		solutionsOLL.add(new Solution("F' U' L' U2 L U L' U' L F'","Knight OLL14", marcelDisabled));
		solutionsOLL.add(new Solution("r' U' r R' U' R U r' U r ","Knight OLL15", marcelDisabled));
		solutionsOLL.add(new Solution("y2 r U r' R U R' U' r U' r' ","Knight OLL16", marcelDisabled));
		solutionsOLL.add(new Solution("R U R' U R' F R F' U2 R' F R F' ","Slash diagonal OLL17", marcelDisabled));
		solutionsOLL.add(new Solution("R U2 R2 F R F' U2 M' U R U' r'","Crown OLL18", marcelDisabled));
		solutionsOLL.add(new Solution("M U R U R' U' M' R' F R F'","Bunny OLL19", marcelDisabled));
		solutionsOLL.add(new Solution("M U R U R' U' M2 U R U' r'"," X OLL20", true));
		solutionsOLL.add(new Solution("R U R' U R U' R' U R U2 R'","Double Sune OLL21", true));
		solutionsOLL.add(new Solution("R U2 R2' U' R2 U' R2 U2 R","Bruno OLL22", true));
		solutionsOLL.add(new Solution("R2 D R' U2 R D' R' U2 R'","Headlights OLL23", true));
		solutionsOLL.add(new Solution("R U R' U' R' F R F'","Hammerhead OLL24", true));
		solutionsOLL.add(new Solution("R' F R B' R' F' R B","Triple Sune OLL25", true));
		solutionsOLL.add(new Solution("L' U' L U' L' U2 L","Anti Sune OLL26", true));
		solutionsOLL.add(new Solution("R' U2 R U R' U R","Sune OLL27", true));
		solutionsOLL.add(new Solution("M' U M U2 M' U M","Stealth OLL28", true));
		solutionsOLL.add(new Solution("M U R U R' U' R' F R F' M'","Akward OLL29", marcelDisabled));
		solutionsOLL.add(new Solution("r' U2 R U R' U r R U2 R' U' R U' R' ","Akward OLL30", marcelDisabled));
		solutionsOLL.add(new Solution("L' U' B U L U' L' B' L","P shape OLL31", marcelDisabled));
		solutionsOLL.add(new Solution("R U B' U' R' U R B R' ","P shape OLL32", marcelDisabled));
		solutionsOLL.add(new Solution("R U R' U' R' F R F'","T shape OLL33", true));
		solutionsOLL.add(new Solution("R U R' U' y' r' U' R U M'","City (C and T) OLL34", marcelDisabled));
		solutionsOLL.add(new Solution("R U2 R2' F R F' R U2 R'","Fish salad OLL35", marcelDisabled));
		solutionsOLL.add(new Solution("R U R' U R U' R' U' R' F R F'","Sea mew OLL36", marcelDisabled));
		solutionsOLL.add(new Solution("F R U' R' U' R U R' F'","Mounted Fish OLL37", true));
		solutionsOLL.add(new Solution("L' U' L U' L' U L U L F' L' F","Mario OLL38", marcelDisabled));
		solutionsOLL.add(new Solution("L F' L' U' L U F U' L'","Big Lightening bolt OLL39", marcelDisabled));
		solutionsOLL.add(new Solution("R' F R U R' U' F' U R ","Big Lightening bolt OLL40", marcelDisabled));
		solutionsOLL.add(new Solution("R' M2 U' F' U F r U' M'","Akward OLL41", marcelDisabled));
		solutionsOLL.add(new Solution("R' U' R U F R U R' U' R' U R U' F'","Akward OLL42", marcelDisabled));
		solutionsOLL.add(new Solution("F' U' L' U L F","Knight  OLL43", true));
		solutionsOLL.add(new Solution("f R U R' U' f' ","P shape OLL44", true));
		solutionsOLL.add(new Solution("F R U R' U' F' ","Suit up OLL45", true));
		solutionsOLL.add(new Solution("R' U' R' F R F' U R ","Seein headlights (C and headl.) OLL46", marcelDisabled));
		solutionsOLL.add(new Solution("F' L' U' L U L' U' L U F","OLL47", true));
		solutionsOLL.add(new Solution("F R U R' U' R U R' U' F'","L shape OLL48", true));
		solutionsOLL.add(new Solution("R B' R2 F R2 B R2 F' R","Right back squeezy OLL49", marcelDisabled));
		solutionsOLL.add(new Solution("y2 R' F R2 B' R2 F' R2 B R'","Right front squeezy OLL50", marcelDisabled));
		solutionsOLL.add(new Solution("F U R U' R' U R U' R' F' ","Bottle cap OLL51", true));
		solutionsOLL.add(new Solution("R' U' R U' R' U F' U F R ","Rice cooker OLL52", marcelDisabled));
		solutionsOLL.add(new Solution("l' U' L U' L' U L U' L' U2 l","L shape OLL53", marcelDisabled));
		solutionsOLL.add(new Solution("r U R' U R U' R' U R U2 r'","L shape OLL54", marcelDisabled));
		solutionsOLL.add(new Solution("R U2 R2 U' R U' R' U2 F R F' ","Highway OLL55", true));
		solutionsOLL.add(new Solution("r U r' U R U' R' U R U' R' r U' r' ","Streetlights OLL56", true));
		solutionsOLL.add(new Solution("R U R' U' l x R' U R U' L'","OLL 57", true));
		addIndex(solutionsOLL);

		ArrayList<Solution> solutionsPLL = scrambler.getSolutionsPLL();
		solutionsPLL.add(new Solution("M2' U M2' U2 M2' U M2'","H permutation", true));
		solutionsPLL.add(new Solution("R2 U' R' U' R U R U R U' R","U a permutation", true));
		solutionsPLL.add(new Solution("R' U R' U' R' U' R' U R U R2 ","U b permutation", true));
		solutionsPLL.add(new Solution("M2' U M2' U M' U2 M2' U2 M' ","Z permutation", true));
		solutionsPLL.add(new Solution("x' R' D R' U2 R D' R' U2 R2 x","A a permutation", true));
		solutionsPLL.add(new Solution("R B' R F2 R' B R F2 R2","A b permutation", true));
		solutionsPLL.add(new Solution("y x' R U' R' D R U R' D' R U R' D R U' R' D' x","E permutation", true));
		solutionsPLL.add(new Solution("R' U R U' R2 F' U' F U R F R' F' R2 U'","F permutation", true));
		solutionsPLL.add(new Solution("y R2' u R' U R' U' R u' R2 y' R' U R","G a permutation", true));
		solutionsPLL.add(new Solution("R' U' R y R2 u R' U R U' R u' R2","G b permutation", true));
		solutionsPLL.add(new Solution("y R2' u' R U' R U R' u R2 y R U' R'","G c permutation", true));
		solutionsPLL.add(new Solution("y2 R U R' y' R2 u' R U' R' U R' u R2","G d permutation", true));
		solutionsPLL.add(new Solution("B' U F' U2 B U' B' U2 F B U'","J a permutation", true));
		solutionsPLL.add(new Solution("B U' F U2 B' U B U2 F' B' U","J b permutation", true));
		solutionsPLL.add(new Solution("L U' R U2 L' U R' L U' R U2 L' U R'  U'","N a permutation", true));
		solutionsPLL.add(new Solution("R' U L' U2 R U' L R' U L' U2 R U' L U ","N b permutation", true));
		solutionsPLL.add(new Solution("R U2 R' U2 R B' R' U' R U R B R2 U","R a permutation", true));
		solutionsPLL.add(new Solution("R' U2 R U2 R' F R U R' U' R' F' R2' U'","R b permutation", true));
		solutionsPLL.add(new Solution("R U R' U' R' F R2 U' R' U' R U R' F'","T permutation", true));
		solutionsPLL.add(new Solution("R' U R' U' B' R' B2 U' B' U B' R B R ","V permutation", true));
		solutionsPLL.add(new Solution("F R U' R' U' R U R' F' R U R' U' R' F R F'","Y permutation", true));
		addIndex(solutionsPLL);
		
		ArrayList<Solution> solutionsF2L = scrambler.getSolutionsF2L();
		solutionsF2L.add(new Solution("U R U' R'","F2L case 1", true));
		solutionsF2L.add(new Solution("U' F' U F","F2L case 2", true));
		solutionsF2L.add(new Solution("F' U' F","F2L case 3", true));
		solutionsF2L.add(new Solution("R U R' ","F2L case 4", true));
		solutionsF2L.add(new Solution("U' R U R' U2 R U' R'","F2L case 5", true));
		solutionsF2L.add(new Solution("U' r U' R' U R U r'","F2L case 6", true));
		solutionsF2L.add(new Solution("R U B U2 B' U R' ","F2L case 7", true));
		solutionsF2L.add(new Solution("r' U2 R2 U R2 U r","F2L case 8", true));
		solutionsF2L.add(new Solution("F2 U R U' R' F2 ","F2L case 9", true));
		solutionsF2L.add(new Solution("U F' U F U' R U R'","F2L case 10", true));
		solutionsF2L.add(new Solution("U' R U2' R' d R' U' R","F2L case 11", true));
		solutionsF2L.add(new Solution("R' U2 R2 U R2 U R","F2L case 12", true));
		solutionsF2L.add(new Solution("U F' U F U' F' U' F","F2L case 13", true));
		solutionsF2L.add(new Solution("U' R U' R' U R U R'","F2L case 14", true));
		solutionsF2L.add(new Solution("U R' F R F' U R U R'","F2L case 15", true));
		solutionsF2L.add(new Solution("R U' R' U2 F' U' F","F2L case 16", true));
		solutionsF2L.add(new Solution("R U2 R' U' R U R'","F2L case 17", true));
		solutionsF2L.add(new Solution("y' R' U2 R U R' U' R","F2L case 18", true));
		solutionsF2L.add(new Solution("U R U2 R2 F R F'","F2L case 19", true));
		solutionsF2L.add(new Solution("U' F' U2 F2 R' F' R","F2L case 20", true));
		solutionsF2L.add(new Solution("R B U2 B' R'","F2L case 21", true));
		solutionsF2L.add(new Solution("F' L' U2 L F","F2L case 22", true));
		solutionsF2L.add(new Solution("U2 R2 U2 R' U' R U' R2 ","F2L case 23", true));
		solutionsF2L.add(new Solution("U F' L' U L F R U R'","F2L case 24", true));
		solutionsF2L.add(new Solution("R' F' R U R U' R' F","F2L case 25", true));
		solutionsF2L.add(new Solution("U R U' R' U' F' U F","F2L case 26", true));
		solutionsF2L.add(new Solution("R U' R' U  R U' R'","F2L case 27", true));
		solutionsF2L.add(new Solution("(F' U F2 R' F' R","F2L case 28", true));
		solutionsF2L.add(new Solution("R' F R F' R' F R F'","F2L case 29", true));
		solutionsF2L.add(new Solution("R U R' U' R U R'","F2L case 30", true));
		solutionsF2L.add(new Solution("F2 r U r' F R U' R'","F2L case 31", true));
		solutionsF2L.add(new Solution("U2 R d' R U R' d R'","F2L case 32", true));
		solutionsF2L.add(new Solution("U' R U' R' U2 R U' R'","F2L case 33", true));
		solutionsF2L.add(new Solution("U R U R' U2 R U R' ","F2L case 34", true));
		solutionsF2L.add(new Solution("U2 R U' R' U' F' U' F","F2L case 35", true));
		solutionsF2L.add(new Solution("U F' U' F U' R U R'","F2L case 36", true));
		solutionsF2L.add(new Solution("SOLVED DEVLOS","F2L case 37", false));
		solutionsF2L.add(new Solution("R2 U2 F R2 F' U2 R' U R'","F2L case 38", true));
		solutionsF2L.add(new Solution("R U' R' F2 L' U' L U F2","F2L case 39", true));
		solutionsF2L.add(new Solution("R U2 R U R' U R U2 R2'","F2L case 40", true));
		solutionsF2L.add(new Solution("y L' U' L U L' U L U2 F U F'","F2L case 41", true));
		solutionsF2L.add(new Solution("R U R' U' R U' R' U2 F' U' F","F2L case 42", true));
		addIndex(solutionsF2L);
		
		
		ArrayList<Solution> solutionsCOLL = scrambler.getSolutionsCOLL();
		solutionsCOLL.add(new Solution("B L U L' U B' R B' R' B2 U2 B'","COLL1", true));		
		solutionsCOLL.add(new Solution("L U' L2 D' l U2 l' D L2 U L'","COLL2", true));
		solutionsCOLL.add(new Solution("R' U R U2 r' R' F R F' r'","COLL3", true));
		solutionsCOLL.add(new Solution("L' U2 L' D2 L U2 L' D2 L2'","COLL4", true));
		solutionsCOLL.add(new Solution("r U R' U' r' y r U r'","COLL5", true));
		solutionsCOLL.add(new Solution("l' U' L U l y' l' U' l","COLL6", true));
		solutionsCOLL.add(new Solution("B U L' B D' B D B2 L2 U' L' B'","COLL7", true));
		solutionsCOLL.add(new Solution("R' U2 R F U' R' U' R U F'","COLL8", true));
		solutionsCOLL.add(new Solution("R2 D2 R' U2 R D2 R' U2 R'","COLL9", true));
		solutionsCOLL.add(new Solution("B' R' B L' B' R y R2 B L' B' R' B L","COLL10", true));
		solutionsCOLL.add(new Solution("L2 D' L U2 L' D L U2 L","COLL11", true));
		solutionsCOLL.add(new Solution("L2 D L' U2 L D' L' U2 L'","COLL12", true));
		solutionsCOLL.add(new Solution("R F' D2 F R' U2 R F' D2 F R'","COLL13", true));
		solutionsCOLL.add(new Solution("F' r U R' U' r' F R","COLL14", true));
		solutionsCOLL.add(new Solution("F' U2 F' D' F U2 F' D F2","COLL15", true));
		solutionsCOLL.add(new Solution("R U2 R D R' U2 R D' R2","COLL16", true));
		solutionsCOLL.add(new Solution("L F' L' B L F L' B'","COLL17", true));
		solutionsCOLL.add(new Solution("r U2 R2 F R F' R U2 r'","COLL18", true));
		solutionsCOLL.add(new Solution("R B2 R2 U2 R B2 R' U2 R2 B2 R'","COLL19", true));
		solutionsCOLL.add(new Solution("R U2 R' U' R U R' U' R U' R'","COLL20", true));
		solutionsCOLL.add(new Solution("R' U2 L' R D L2 U L2 D' B2 L","COLL21", true));
		solutionsCOLL.add(new Solution("F' U' F U' F' U' B U' F U B'","COLL22", true));
		solutionsCOLL.add(new Solution("R U2 R2 U' R2 U' R2 U2 R","COLL23", true));
		solutionsCOLL.add(new Solution("F' R U F2 R' U R U' F2 U' R' F","COLL24", true));
		solutionsCOLL.add(new Solution("L U' R' U L' U R U R' U R","COLL25", true));
		solutionsCOLL.add(new Solution("F R2 U' R2 U R2 U F' y R U2 R'","COLL26", true));
		solutionsCOLL.add(new Solution("L U2 r' U L' U R U R' U2 L U'","COLL27", true));
		solutionsCOLL.add(new Solution("L' U2 L F' L F' R' F' R F2 L' F","COLL28", true));
		solutionsCOLL.add(new Solution("R U R' U R U2 R'","COLL29", true));
		solutionsCOLL.add(new Solution("F R' U2 R F' R' F U2 F' R","COLL30", true));
		solutionsCOLL.add(new Solution("F' U2 B U' F U B' U F' U F","COLL31", true));
		solutionsCOLL.add(new Solution("L U' R' U L' U' R","COLL32", true));
		solutionsCOLL.add(new Solution("B' U' R U R' B U R U2 R'","COLL33", true));
		solutionsCOLL.add(new Solution("R' U2 R U F R' U R U' F'","COLL34", true));
		solutionsCOLL.add(new Solution("R' U' R U' R' U2 R","COLL35", true));
		solutionsCOLL.add(new Solution("F' L U2 L' F L F' U2 F L'","COLL36", true));
		solutionsCOLL.add(new Solution("F U2 B' U F' U' B U' F U' F'","COLL37", true));
		solutionsCOLL.add(new Solution("L' U R U' L U R'","COLL38", true));
		solutionsCOLL.add(new Solution("B U L' U' L B' U' L' U2 L","COLL39", true));
		solutionsCOLL.add(new Solution("F U2 F' U' R' F U' F' U R","COLL40", true));
		solutionsCOLL.add(new Solution("L' U R' U2 L U' L' U2 R L","COLL41", true));
		solutionsCOLL.add(new Solution("F R U' R' F D R' B' R' B R2 D' F2","COLL42", true));
		addIndex(solutionsCOLL);
		
		ArrayList<Solution> solutionsCMLL = scrambler.getSolutionsCMLL();
		solutionsCMLL.add(new Solution("R U R' F' R U R' U' R' F R2 U' R'","J-Perm", true));		
		solutionsCMLL.add(new Solution("F R U' R' U' R U R' F' R U R' U' R' F R F'","Y-perm", true));
		solutionsCMLL.add(new Solution("U R' U' R U' R' U2 R","Anti-Sune - B1", true));
		solutionsCMLL.add(new Solution("U' R2 D R' U R D' R' U R' U' R U' R'","Pancake - B2", true));
		solutionsCMLL.add(new Solution("x' F U' R U L' U2 R' U2 R","Evil Forte - B3", true));
		solutionsCMLL.add(new Solution("U' R U2 R' U2 R' F R F'","Juice10 - B4", true));
		solutionsCMLL.add(new Solution("U' L' U  R U' L U R'","Anti-Niklas - B5", true));
		solutionsCMLL.add(new Solution("U' R' U' R U' L U' R' U L' U2 R","Sune - C1", true));
		solutionsCMLL.add(new Solution("U' R' F2 R U2 R U' L' U x'","Justin - C2", true));
		solutionsCMLL.add(new Solution("U' x U R' U' L U2 R U2 R'","Forte - C3", true));
		solutionsCMLL.add(new Solution("U2 R U R' U R U' R D R' U' R D' R2","Waffo - C4", true));
		solutionsCMLL.add(new Solution("U' R U' L' U R' U' L","Niklas - C5", true));
		solutionsCMLL.add(new Solution("U R U R' U L' U R U' L U2 R'","Y-Sune - C6", true));
		solutionsCMLL.add(new Solution("R U2 R' U' R U R' U' R U R' U' R U' R'","Jude - D1", true));
		solutionsCMLL.add(new Solution("U R' U2 R' D' R U2 R' D R2","LOLBEN - D2", true));
		solutionsCMLL.add(new Solution("U2 R' U' R U2 L' U R' U' L U' R","Spin-Ben - D3", true));
		solutionsCMLL.add(new Solution("L' U' L' U R U' L U x'","Rowe - D4", true));
		solutionsCMLL.add(new Solution("x L' D L U' L' D' L U x'","Harris - D5", true));
		solutionsCMLL.add(new Solution("L' U2 R U' Rw' U2 R Lw U' R'","Rowe D6", true));
		solutionsCMLL.add(new Solution("R' U' R U' R' U2 R2 U R' U R U2 R'","2GENU - E1", true));
		solutionsCMLL.add(new Solution("U' F R2 D R' U R D' R2' U' F'","Rob E2", true));
		solutionsCMLL.add(new Solution("U2 R2 D R' U2 R D' R' U2 R'","FML R - E3", true));
		solutionsCMLL.add(new Solution("U2 R' F U' R F R' U R F'","Minivan - E4", true));
		solutionsCMLL.add(new Solution("R2 D' R U2 R' D R U2 R","FML L - E5", true));
		solutionsCMLL.add(new Solution("U' F R U R' U' F'","FRURUF - E6", true));
		solutionsCMLL.add(new Solution("R U2 R' U' R U' R2' U2' R U R' U R","2GENT - F1", true));
		solutionsCMLL.add(new Solution("R' U Rw U2 R2' F R F' R","MOOP - F2", true));
		solutionsCMLL.add(new Solution("U' R' U' R U L U' R' U x","Brownie - F3", true));
		solutionsCMLL.add(new Solution("F U' L' U R2 U' L U R' Lw' U' x'","Rocketship - F4", true));
		solutionsCMLL.add(new Solution("U' R U R' U' R' F R F'","COOKIE - F5", true));
		solutionsCMLL.add(new Solution("R' U R2 D Rw' U2 Rw D' R2' U' R","Blastoise - F6", true));
		solutionsCMLL.add(new Solution("F R U R' U' R U R' U' F'","Dead Guy - G1", true));
		solutionsCMLL.add(new Solution("R' U' R U' R' U2 R U' L' U R U' L U R'","Shoot DOwn - G2", true));
		solutionsCMLL.add(new Solution("L' U2 y R U2 R' U2 R' U2 F y x","Anfony - G3", true));
		solutionsCMLL.add(new Solution("R U R' U R U2 R' U' R U' L' U R' U' L","Shoot up - G4", true));
		solutionsCMLL.add(new Solution("R' U L U' R U' L' U' L U' L'","Westicles - G5", true));
		solutionsCMLL.add(new Solution("U2 R U R' U R U' y R U' R' y L'","Woner - G6", true));
		solutionsCMLL.add(new Solution("R U2 R' U' R U R' U' R U' R'","Sex - H1", true));
		solutionsCMLL.add(new Solution("U' R U R' U R U L' U R' U' L","Sela - H2", true));
		solutionsCMLL.add(new Solution("L' U2 y R U2 R U2 R' U2 F y x","CMLL40", true));
		solutionsCMLL.add(new Solution("R' F R F' U2 R2 B' R' B R'","Data - H3", true));
		solutionsCMLL.add(new Solution("F R U R' U' R U R' U' R U R' U' F'","Sexy Moves - H4", true));
		addIndex(solutionsCMLL);
		
		ArrayList<Solution> solutionsCLL = scrambler.getSolutionsCLL();
		solutionsCLL.add(new Solution("R2 F' U F U' F' U' F2 R F' R","CLL1", true));		
		solutionsCLL.add(new Solution("y' F R U R' U' F'","CLL2", true));
		solutionsCLL.add(new Solution("y2 R2 D R' U2 R D' R' U2 R'","CLL3", true));
		solutionsCLL.add(new Solution("R2 F2 R' B2 R F2 R' B2 R'","CLL4", true));
		solutionsCLL.add(new Solution("R2' D' R U2 R' D R U2 R","CLL5", true));
		solutionsCLL.add(new Solution("y2 r' y' R' U2 L' U R U' L U2 y r", "CLL6", true));
		solutionsCLL.add(new Solution("F R' F R2 U' R' U' R U R' F2","CLL7", true));
		solutionsCLL.add(new Solution("F2 L2 F' U R U' R' F L2 F2","CLL8", true));
		solutionsCLL.add(new Solution("y' r' U' R U L U' R' U x","CLL9", true));
		solutionsCLL.add(new Solution("y' l' U2 R' D2 R U2 R' D2 R2 x'","CLL10", true));
		solutionsCLL.add(new Solution("y l U L' U' R' U L U' x","CLL11", true));
		solutionsCLL.add(new Solution("R' U R U2 L' R' U R U' L","CLL12", true));
		solutionsCLL.add(new Solution("L B' D2 B L' U2 L B' D2 B L'","CLL13", true));
		solutionsCLL.add(new Solution("y R U2 R2 F R F' R U2 R'","CLL14", true));
		solutionsCLL.add(new Solution("x' U' R U L' U' R' U r","CLL15", true));
		solutionsCLL.add(new Solution("y2 L' U2 L' D' L U2 L' D L2","CLL16", true));
		solutionsCLL.add(new Solution("y R U2 R D R' U2 R D' R2","CLL17", true));
		solutionsCLL.add(new Solution("y' x' U L' U' R U L U' l'","CLL18", true));
		solutionsCLL.add(new Solution("y' R U R' U R U2 R'","CLL19", true));
		solutionsCLL.add(new Solution("y R U R' U L' U R U' L U2 R'","CLL20", true));
		solutionsCLL.add(new Solution("y' L' U2 L U2 L F' L' F","CLL21", true));
		solutionsCLL.add(new Solution("y' F R' F' R U2 R U2 R'","CLL22", true));
		solutionsCLL.add(new Solution("B L' U2 L B' L' B U2 B' L","CLL23", true));
		solutionsCLL.add(new Solution("y' R U' L' U R' U' L","CLL24", true));
		solutionsCLL.add(new Solution("R' U' R U' R' U2 R","CLL25", true));
		solutionsCLL.add(new Solution("L' U' L U' R U' L' U R' U2 L","CLL26", true));
		solutionsCLL.add(new Solution("x' M' U' R U L' U2 R' U2 R","CLL27", true));
		solutionsCLL.add(new Solution("L U2 L' U2 r' U L U' x","CLL28", true));
		solutionsCLL.add(new Solution("R' U L U' R U L'","CLL29", true));
		solutionsCLL.add(new Solution("L' B U2 B' L B L' U2 L B'","CLL30", true));
		solutionsCLL.add(new Solution("R U2 R' U' R U R' U' R U' R'","CLL31", true));
		solutionsCLL.add(new Solution("F R U R' U' R U R' U' R U R' U' F'","CLL32", true));
		solutionsCLL.add(new Solution("y' R U2 R2 F R F' U2 R' F R F'","CLL33", true));
		solutionsCLL.add(new Solution("R' F R F' U2 R2 B' R' B R'","CLL34", true));
		solutionsCLL.add(new Solution("y R U2 R2 U' R2 U' R2 U2 R","CLL35", true));
		solutionsCLL.add(new Solution("y' R' U' R U' R' U F' U F R","CLL36", true));
		solutionsCLL.add(new Solution("y2 F' U' L' U L2 F L' U2 L' U2 L","CLL37", true));
		solutionsCLL.add(new Solution("y R B' R B R2 U2 F R' F' R","CLL38", true));
		solutionsCLL.add(new Solution("y2 F U R U' R2 F' R U2 R U2 R'","CLL39", true));
		solutionsCLL.add(new Solution("y' F R' F' R U2 F R' F' R2 U2 R'","CLL40", true));
		addIndex(solutionsCLL);
		
		ArrayList<Solution> solutionsZBLLH = scrambler.getSolutionsZBLLH();
		solutionsZBLLH.add(new Solution("R U2 R' U' R U' R' U' R' U' R U' R' U2 R","ZBLLH1", true));		
		solutionsZBLLH.add(new Solution("R' U' R U' R' U R U' R' U2 R","ZBLLH2", true));
		solutionsZBLLH.add(new Solution("R U2 R' U' R U R' U' R U' R'","ZBLLH3", true));
		solutionsZBLLH.add(new Solution("F R U R' x U R' U' R x' U' R U R' x U R' U' R x' U' F'","ZBLLH4", true));
		solutionsZBLLH.add(new Solution("R' U2 R U R' U' R U R' U R","ZBLLH5", true));
		solutionsZBLLH.add(new Solution("R' U2 R U R' U R U R U R' U R U2 R'", "ZBLLH6", true));
		solutionsZBLLH.add(new Solution("L U L' U L U' L' U L U2 L'","ZBLLH7", true));
		solutionsZBLLH.add(new Solution("U R D R' U' R D' x' U' L' U R' U' L","ZBLLH8", true));
		solutionsZBLLH.add(new Solution("F' L U' L' U2 L2 U L' U2 L U L2 U' F","ZBLLH9", true));
		solutionsZBLLH.add(new Solution("B L' U L U2 L2 U' L U2 L' U' L2 U B'","ZBLLH10", true));
		solutionsZBLLH.add(new Solution("l' U2 R' u2 R B2 U2 R' u2 l U2 R","ZBLLH11", true));
		solutionsZBLLH.add(new Solution("R U' L' U R2 U2 L R2 U' L' U R2 U R L","ZBLLH12", true));
		solutionsZBLLH.add(new Solution("L' U R U' L2 U2 R' L2 U R U' L2 U' R' L'","ZBLLH13", true));
		solutionsZBLLH.add(new Solution("F R U R' U' R U R' U' R U R' U' F'","ZBLLH14", true));
		solutionsZBLLH.add(new Solution("R2 F R F' R' U2 R' U2 R U2 x' U' R2 U R","ZBLLH15", true));
		solutionsZBLLH.add(new Solution("U R U2 R' F2 D R2 U' R2 D' L' U L U2","ZBLLH16", true));
		solutionsZBLLH.add(new Solution("R2 D r' U2 r D' R U' R2 U' R2 U2 R","ZBLLH17", true));
		solutionsZBLLH.add(new Solution("L' U R U' L2 U L' R' U2 L U L'","ZBLLH18", true));
		solutionsZBLLH.add(new Solution("R' U' R U' R' U' L U' R U L'","ZBLLH19", true));
		solutionsZBLLH.add(new Solution("U' R U L' U2 R' U' L' U' L2 u r2 U'","ZBLLH20", true));
		solutionsZBLLH.add(new Solution("L U2 L2 U' L' D L' U' L D' L U2 L","ZBLLH21", true));
		solutionsZBLLH.add(new Solution("R U R' U R U L' U R' U' L","ZBLLH22", true));
		solutionsZBLLH.add(new Solution("F' U2 R' F R U2 R2 r U L' U' R2 U","ZBLLH23", true));
		solutionsZBLLH.add(new Solution("U2 R2 U R D' R U R' D R' U2 R'","ZBLLH24", true));
		solutionsZBLLH.add(new Solution("L U2 R' U L' U L U L' U' L U' R U2 L'","ZBLLH25", true));
		solutionsZBLLH.add(new Solution("U R' U' L U2 R U L U L2 u' r2 U","ZBLLH26", true));
		solutionsZBLLH.add(new Solution("L' U2 R U' L U' L' U' L U L' U R' U2 L","ZBLLH27", true));
		solutionsZBLLH.add(new Solution("R U' L' U R2 U' R L U2 R' U' R","ZBLLH28", true));
		solutionsZBLLH.add(new Solution("L U L' F' L U' L2 U L F2 R U R' U' F'","ZBLLH29", true));
		solutionsZBLLH.add(new Solution("R' B' R2 U R2 U R2 U2 R2 U B R","ZBLLH30", true));
		solutionsZBLLH.add(new Solution("R' F R F' U2 x' R2 U L' U L U2 R2","ZBLLH31", true));
		solutionsZBLLH.add(new Solution("L' U2 L2 F' U L2 U L2 U' F U' L'","ZBLLH32", true));
		solutionsZBLLH.add(new Solution("L' U2 M' x' D R2 U R2 u' R2 B","ZBLLH33", true));
		solutionsZBLLH.add(new Solution("R U2 R2 F U' R2 U' R2 U F' U R","ZBLLH34", true));
		solutionsZBLLH.add(new Solution("R F R2 U' R2 U' R2 U2 R2 U' F' R'","ZBLLH35", true));
		solutionsZBLLH.add(new Solution("L F' L' F U2 x' L2 U' R U' R' U2 L2","ZBLLH36", true));
		solutionsZBLLH.add(new Solution("R' U' R F R' U R2 U' R' F2 L' U' L U F","ZBLLH37", true));
		solutionsZBLLH.add(new Solution("R U2 M' x U' L2 D' L2 U x' U2 L'","ZBLLH38", true));
		solutionsZBLLH.add(new Solution("F R U R' U2 y' F' L2 u' L u L2 F U' R'","ZBLLH39", true));
		solutionsZBLLH.add(new Solution("F R U' R' U R U2 R' U' R U R' U' F'","ZBLLH40", true));
		addIndex(solutionsZBLLH);
		
		ArrayList<Solution> solutionsEG1 = scrambler.getSolutionsEG1();
		
		solutionsEG1.add(new Solution("U x U' R2' U' R2 U' x' U' F2 R2","U Case 1", true));
		solutionsEG1.add(new Solution("F' U2 R U2 R' U2 F","U Case 2", true));
		solutionsEG1.add(new Solution("U2 R' F R2 U' R' U y' R U R'","U Case 3", true));
		solutionsEG1.add(new Solution("U R' F R F' R' F R2 U' R'","U Case 4", true));
		solutionsEG1.add(new Solution("U2 L F' L2' U L U' y' R' U' R","U Case 5", true));
		solutionsEG1.add(new Solution("y' R' U R' U' R U' R' U' R2","U Case 6", true));

		solutionsEG1.add(new Solution("U2 R U' R' F' U' x U R' U' R U","T Case 1", true));
		solutionsEG1.add(new Solution("U2 R U' R' U2 F R U2 R' F","T Case 2", true));
		solutionsEG1.add(new Solution("x U' R' U R2 x' U R' U' R U R'","T Case 3", true));
		solutionsEG1.add(new Solution("U R U R2 x U' R U R' U' R","T Case 4", true));
		solutionsEG1.add(new Solution("x U L U' L2 x' U' L U L' U' L","T Case 5", true));
		solutionsEG1.add(new Solution("U R U' R2 F R U R U2 R'","T Case 6", true));

		solutionsEG1.add(new Solution("U' R' F R2 U R' F' R U2 R'","L Case 1", true));
		solutionsEG1.add(new Solution("R U R2' F' R y' U' R' U R","L Case 2", true));
		solutionsEG1.add(new Solution("F U' F' U' R U R2' F' R","L Case 3", true));
		solutionsEG1.add(new Solution("L' U L U' L' U L2 F L' F'","L Case 4", true));
		solutionsEG1.add(new Solution("R U' R' U R U' R2 F' R F","L Case 5", true));
		solutionsEG1.add(new Solution("U' R' U R2 U' R2 U' F R2 U' R'","L Case 6", true));

		solutionsEG1.add(new Solution("U2 F2 R U R' U2 R U R' U' F","Pi Case 1", true));
		solutionsEG1.add(new Solution("F R U' R' F R U2 R' U F'","Pi Case 2", true));
		solutionsEG1.add(new Solution("U' R U' R' U R U' R' F R U' R'","Pi Case 3", true));
		solutionsEG1.add(new Solution("R U' R2 F R U R U' R' U' R' F R F'","Pi Case 4", true));
		solutionsEG1.add(new Solution("U' F R' F U' F2 R U R","Pi Case 5", true));
		solutionsEG1.add(new Solution("U' R' F R2 U' R2 F R","Pi Case 6", true));

		solutionsEG1.add(new Solution("U' R' F R2 U' R2 U' F U R","H Case 1", true));
		solutionsEG1.add(new Solution("U' R U R' F' R U R' U' R U R' U'","H Case 2", true));
		solutionsEG1.add(new Solution("R' U' R' F2 U x U' R U'","H Case 3", true));
		solutionsEG1.add(new Solution("U R U R' F' R U R' U' R U R' U'","H Case 4", true));
		solutionsEG1.add(new Solution("U2 R' U' R' F2 U x U' R U' ","H Case 5", true));
		solutionsEG1.add(new Solution("x R U R2 U' B R2' U' R U","H Case 6", true));
		
		solutionsEG1.add(new Solution("z' R' U' R U2 x' U2 R U'","Sune Case 1", true));
		solutionsEG1.add(new Solution("R' F R2 U' R' U L F' L' F","Sune Case 2", true));
		solutionsEG1.add(new Solution("U' R' F R U2 R U' R2 F2 R F'","Sune Case 3", true));
		solutionsEG1.add(new Solution("U R U' R' U R U' R' U F R U' R'","Sune Case 4", true));
		solutionsEG1.add(new Solution("U R U R' F2 R' F2 R U' F","Sune Case 5", true));
		solutionsEG1.add(new Solution("R B2 U' R2 F z' R U2 R' F","Sune Case 6", true));

		solutionsEG1.add(new Solution("U' B U' R2 F2 U' F","Anti Sune Case 1", true));
		solutionsEG1.add(new Solution("U' R U R' F' U' R U R' U' R U R'","Anti Sune Case 2", true));
		solutionsEG1.add(new Solution("F' L F L' U' R U R2 F' R","Anti Sune Case 3", true));
		solutionsEG1.add(new Solution("U2 R U' R2 F R U' R' F R F'","Anti Sune Case 4", true));
		solutionsEG1.add(new Solution("R U' R' F' U' R U R' U' F","Anti Sune Case 5", true));
		solutionsEG1.add(new Solution("R U' F2 R U2 R U' F","Anti Sune Case 6", true));
		addIndex(solutionsEG1);

		ArrayList<Solution> solutionsF2LE = scrambler.getSolutionsF2LE();
		
		solutionsF2LE.add(new Solution("R U R' U2 R U' R' U R U' R'","F2LE1", true));
		solutionsF2LE.add(new Solution("R U' R' U2 F' U' F","F2LE2", true));
		solutionsF2LE.add(new Solution("R' F R U R' F' R L' U' L","F2LE3", true));
		solutionsF2LE.add(new Solution("L' U L U2 F U F'","F2LE4", true));
		solutionsF2LE.add(new Solution("R' U' R U' R' U2 R2 U' R'","F2LE5", true));
		solutionsF2LE.add(new Solution("R U R2 F R F' R U' R'","F2LE6", true));
		solutionsF2LE.add(new Solution("F' L' U L F R U R'","F2LE7", true));
		solutionsF2LE.add(new Solution("R2 U2 R' U' R U' R2","F2LE8", true));
		solutionsF2LE.add(new Solution("L U L' U L U2 L2 U L","F2LE9", true));
		solutionsF2LE.add(new Solution("L2 U2 L U L' U L2","F2LE10", true));
		solutionsF2LE.add(new Solution("F R U' R' F' L' U' L","F2LE11", true));
		solutionsF2LE.add(new Solution("R U2 R' U' R U R'","F2LE12", true));
		solutionsF2LE.add(new Solution("F' U2 F U F' U' F","F2LE13", true));
		solutionsF2LE.add(new Solution("L' U2 L U L' U' L","F2LE14", true));
		solutionsF2LE.add(new Solution("L' U L U2 F U F'","F2LE15", true));
		solutionsF2LE.add(new Solution("F' U' F U' R U R'","F2LE16", true));
		solutionsF2LE.add(new Solution("R U' R' U R U' R' U2 R U' R'","F2LE17", true));
		  
		
		addIndex(solutionsF2LE);
		
		ArrayList<Solution> solutionsWV = scrambler.getSolutionsWV();
		solutionsWV.add(new Solution("U' L' U2 R U' R' U2 L","WV-01", true));		
		solutionsWV.add(new Solution("U R U' R'","WV-02", true));
		solutionsWV.add(new Solution("R' F R U R U' R' F'","WV-03", true));
		solutionsWV.add(new Solution("U R2 D R' U' R D' R2","WV-04", true));
		solutionsWV.add(new Solution("U R U' R' U R' U' R U' R' U2 R","WV-05", true));
		solutionsWV.add(new Solution("R U' R' U2 R U' R' U2 R U R'","WV-06", true));
		solutionsWV.add(new Solution("U R U R' U' R U' R'","WV-07", true));
		solutionsWV.add(new Solution("U2 R U' R' U R U2 R'","WV-08", true));
		solutionsWV.add(new Solution("U2 F' R U2 R' U2 R' F R","WV-09", true));
		solutionsWV.add(new Solution("R' F R2 U R' U' R U R' U' F'","WV-10", true));
		solutionsWV.add(new Solution("U2 R' U' R2 U' R2 U2 R","WV-11", true));
		solutionsWV.add(new Solution("U y' x' R' F' R U' R U R2 F R","WV-12", true));
		solutionsWV.add(new Solution("U2 R U2 R2 U' R U' R' U2 R","WV-13", true));
		solutionsWV.add(new Solution("U2 L' U R U' L U2 R'","WV-14", true));
		solutionsWV.add(new Solution("L' U R U' R' L","WV-15", true));
		solutionsWV.add(new Solution("U2 L' R U R' U' L R U2 R'","WV-16", true));
		solutionsWV.add(new Solution("U2 R U2 R'","WV-17", true));
		solutionsWV.add(new Solution("R' F' R U2 R U2 R' F","WV-18", true));
		solutionsWV.add(new Solution("R' F2 R2 U' R' U' R U R' F2","WV-19", true));
		solutionsWV.add(new Solution("U R U' R' U' R U R' U R U2 R'","WV-20", true));
		solutionsWV.add(new Solution("U R U' R2 U2 R U R' U R","WV-21", true));
		solutionsWV.add(new Solution("U R2 D R' U R D' R' U2 R'","WV-22", true));
		solutionsWV.add(new Solution("R2 U R' U R' U' R U R U2 R2","WV-23", true));
		solutionsWV.add(new Solution("U2 R U' R' U R U' R' U R U2 R'","WV-24", true));
		solutionsWV.add(new Solution("U2 R U2 R2 U2 R U R' U R","WV-25", true));
		solutionsWV.add(new Solution("U R U' R2 U' R U' R' U2 R","WV-26", true));
		solutionsWV.add(new Solution("U R U R' U' R U R' U' R U' R'","WV-27", true));
		addIndex(solutionsWV);
		
	}
	
	private static void addIndex(ArrayList<Solution> list){
		int count = 1;
		for(Solution solution: list){
			solution.setId(count);
			count++;
		}
		
	}

	

	
}
