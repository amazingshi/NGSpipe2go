// bowtie parameters
BOWTIE_THREADS=" -p" + Integer.toString(ESSENTIAL_THREADS) // threads to use
BOWTIE_REF=ESSENTIAL_BOWTIE_REF // prefix of the bowtie reference genome
BOWTIE_INSERT="-l 28"			// seed size. Match with fragment size
BOWTIE_MM_SEED="-n 2"			// number of mismatches allowed in the seed
BOWTIE_MAQERR="-e 70"			// max sum of quals for -n mismatches
BOWTIE_MULTIMAP="-m 1"			// discard reads mapping to more than MULTIMAP positions
BOWTIE_BEST="--best --strata --chunkmbs 256"	// bowtie best mode
BOWTIE_QUALS="--phred33-quals"	// phred33-quals. Use --phred64-quals for old sequencing runs
BOWTIE_EXTRA=""                 // extra parms to be passed to bowtie

// samtools parameters
SAMTOOLS_THREADS="-@" + Integer.toString(ESSENTIAL_THREADS)
