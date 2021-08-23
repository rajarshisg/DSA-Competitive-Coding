/*
   Question Link - https://codeforces.com/problemset/problem/975/C
*/

#include<iostream>
using namespace std;
int upperBound(long long arr[], int n, long long key) {
    int low = 0, high = n - 1;
    
    while(low <= high) {
        int mid = low + (high - low) / 2;
        if(arr[mid] <= key) low = mid + 1;
        if(arr[mid] > key) high = mid - 1;
    }
    
    return low;
}
 
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);   
    int n, q;
    cin>>n>>q;
    int arr[n]; //health of each soldier
    long long prefix[n]; //number of arrows needed to kill all soldiers till ith
    
    for(int i=0;i<n;i++) {
        cin>>arr[i];
        if(i == 0) {
            prefix[i] = arr[i];
        }else {
            prefix[i] = arr[i] + prefix[i - 1];
        }
    }
    
    long long arrows = 0;
    
    while(q-->0) {
        long long currArrows;
        cin>>currArrows;
        arrows += currArrows;
        
        if(arrows >= prefix[n - 1]) {
            arrows = 0;
            cout<<n<<"\n";
        }else {
            int ub = upperBound(prefix, n, arrows);
            cout<<n - ub<<"\n";
        }
    }
}
