![IMB-logo](resources/IMB_logo.png)

# NGSpipe2go #

An opinionated framework for building pipelines. It comprises set of NGS data analysis tools and pipelines developed and utilised at the Institute of Molecular Biology gGmbH in Mainz (https://www.imb.de/).

![NGSpipe2go scheme](resources/NGSpipe2go_scheme.png)

## Available Pipelines ## 

- [ChIP-Seq](https://gitlab.rlp.net/imbforge/NGSpipe2go/-/blob/devel/pipelines/ChIPseq/README.md)
- DNA-Seq
- [RNA-Seq](https://gitlab.rlp.net/imbforge/NGSpipe2go/-/blob/devel/pipelines/RNAseq/README.md)
- RNA-Seq for variant calling
- smallRNA-Seq
- [single cell RNA-Seq](https://gitlab.rlp.net/imbforge/NGSpipe2go/-/blob/devel/pipelines/scRNAseq/README.md)

## NGSpipe2go preparations ##

### Put NGSpipe2go into the project dir ###

NGS projects should be run in a consistant and reproducible way, hence NGSpipe2go asks you to copy all tools into the project folder, which will ensure that you always use the same program versions at a later time point. This can be done either from a local NGSpipe2go copy, a version from the GitHub releases (https://github.com/imbforge/NGSpipe2go/releases) or using the most recent development version from the GitHub repository

    git clone https://gitlab.rlp.net/imbforge/NGSpipe2go <project_dir>/NGSpipe2go

### Choose one of the pipelines ###

Select a pipeline to run and make symlinks in the main project dir, e.g. for RNA-seq project

    ln -s NGSpipe2go/pipelines/RNAseq/* .

or for ChIP-seq project

    ln -s NGSpipe2go/pipelines/ChIPseq/* .

### Customise NGSpipe2go to your needs ###

Adjust the project-specific information in the pipeline dependent files (see pipeline specific README files for detailed information):

- *essential.vars.groovy* specifies the main project variables like project dir and reference genome
- *xxx.vars.groovy* additional software parameters can be customised in the vars-file accompanying each bpipe module.
- *xxx.pipeline.groovy* describes the steps of the selected pipeline and the location of the respective modules
- *targets.txt* and *contrasts.txt* contain the sample names and the differential group comparisons

Adjust general pipeline settings in the NGSpipe2go *config* folder:

- *bpipe.config.groovy*: define workload manager resources (default workload manager is "slurm", if not needed set executor="local")
- *preambles.groovy*: define module preamples if needed (or stay with default preambles)
- *tools.groovy*: defines default versions and running environments for all installed pipeline tools. It needs to be updated accordingly if new tools or tool versions are installed on your system. If you want to use a different tool version for a certain project you can overwrite the default value in the pipeline-specific tools.groovy file in *NGSpipe2go/pipelines/<pipeline>/tools.groovy*.

## Run a pipeline ##

Copy the input FastQ files into the <project_dir>/rawdata folder.

Using GNU Screen (for persistence) load the bpipe module customised for the Slurm job manager, e.g.

    screen
    module load bpipe/0.9.9.8.slurm

Start running the pipeline of choice, e.g.

    bpipe run rnaseq.pipeline.groovy rawdata/*.fastq.gz

or

    bpipe run chipseq.pipeline.groovy rawdata/*.fastq.gz    

## Compile a project report ##

The final result of the provided pipelines will be saved in the ./reports folder.
The Rmd file can be edited or customised using a text editor and then converted into HTML report using knitr
    
    R usage:
    rmarkdown::render("DEreport.Rmd")
    or
    rmarkdown::render("ChIPreport.Rmd")
