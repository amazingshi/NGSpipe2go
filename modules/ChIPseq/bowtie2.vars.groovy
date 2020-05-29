bowtie2_vars=[
    mapped          : MAPPED,                // output directory
    paired          : RUN_IN_PAIRED_END_MODE, // run in se or pe mode
    threads         : Integer.toString(ESSENTIAL_THREADS), // threads to use
    samtools_threads: Integer.toString(ESSENTIAL_THREADS), // threads to use
    ref             : ESSENTIAL_BOWTIE_REF,  // prefix of the bowtie reference genome
    presets         : "--very-sensitive",    // preset alignment settings. For very polymorphic samples one can try the "super-sensitive" but >2x slower parameter combination "-D 20 -R 3 -N 1 -L 20 -i S,1,0.50"
    seedMM          : "",                    // max number of mismatches in seed alignment; can be 0 or 1, the default -N 0 is set by --very-sensitive
    seedSubstr      : "",                    // length of seed substrings. Match with fragment size, the default -L 20 is set by --very-sensitive
    interval        : "",                    // interval between seed substrings, the default -i S,1,0.50 is set by --very-sensitive
    extend          : "",                    // give up extending after <int> failed extends in a row, the default -D 20 is set by --very-sensitive
    sets            : "",                    // for reads with repetitive seeds, try <int> sets of seeds, the default -R 3 is set by --very-sensitive
    quals           : "--phred33",           // phred33-quals. Use --phred64-quals for old sequencing runs
    pe_vars         : "--fr --maxins 1000 --minins 0",  // vars applied only in paired end design. Mates align fw/rev, maximum and minimum fragment length
    extra           : "--end-to-end"  // entire read must align
]
