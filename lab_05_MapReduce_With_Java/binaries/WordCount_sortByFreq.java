import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

//Sample output
//539     it
//625     of
//683     a
//800     to
//910     and
//1803    the



public class WordCount_sortByFreq {

  public static class FrequencySortMap extends  Mapper<Object, Text, IntWritable, Text>
    {
      public void map(Object key, Text value, Context context
                ) throws IOException, InterruptedException
      {
          String line = value.toString();
             StringTokenizer stringTokenizer = new StringTokenizer(line);
             System.out.println(line);
    if(stringTokenizer.countTokens() == 2){
      int frequency = 0; 
      String word = "";
      word = stringTokenizer.nextToken();
      frequency = Integer.parseInt(stringTokenizer.nextToken());
      context.write(new IntWritable(frequency), new Text(word));
    }
      }
    }
    
  //public static class SwapReducer extends Reducer<IntWritable,Text,Text,IntWritable> {
  //  public void reduce(IntWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
  //    for (Text val : values){
  //      context.write(val, key);
  //    }
  //  }
  //}  
 
  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    Job job = Job.getInstance(conf, "freq sort");
    job.setJarByClass(WordCount_sortByFreq.class);
    job.setMapperClass(FrequencySortMap.class);
  //  job.setCombinerClass(SwapReducer.class);
  //  job.setReducerClass(SwapReducer.class);
    //job.setInputKeyClass(IntWritable.class);
    //job.setInputValueClass(Text.class);
    job.setOutputKeyClass(IntWritable.class);
    job.setOutputValueClass(Text.class);
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}