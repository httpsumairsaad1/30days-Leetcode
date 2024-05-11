// Solution in detaled explanation: https://leetcode.com/problems/minimum-cost-to-hire-k-workers/solutions/5142004/beats-96-71-super-easy-solution-with-explanation/?envType=daily-question&envId=2024-05-11 
// hard
// beats 99.71%
class Solution {
    class WorkerRatio{
        double ratio;
        int quality;
        public WorkerRatio(double r, int q){
            ratio = r;
            quality=q;
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        WorkerRatio[] ratio = new WorkerRatio[n];
        for(int i=0 ; i< n ;++i) ratio[i] = new WorkerRatio((double)wage[i]/quality[i],quality[i]);
        Arrays.sort(ratio,(a,b)-> Double.compare(a.ratio,b.ratio));
        Queue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int sum=0;
        for(int i=0; i<k ; ++i){
            pq.add(ratio[i].quality);
            sum+=ratio[i].quality;
        }
        double baseRatio = ratio[k-1].ratio;
        double ans = baseRatio*sum;
        for(int i=k ; i<n ; ++i){
            double newRatio = ratio[i].ratio;
            // get k smallest quality between 0,i
            int cur_equality = ratio[i].quality;
            if(pq.peek() > cur_equality){
                sum-=pq.poll();
                pq.add(cur_equality);
                sum+=cur_equality;
            }
            ans = Math.min(ans,newRatio*sum);
        }
        return ans;
    }
}
